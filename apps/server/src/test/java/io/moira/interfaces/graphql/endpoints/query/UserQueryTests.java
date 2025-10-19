package io.moira.interfaces.graphql.endpoints.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import autoparams.AutoParams;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import com.netflix.graphql.dgs.test.EnableDgsTest;
import io.moira.codegen.client.UserGraphQLQuery;
import io.moira.codegen.client.UserProjectionRoot;
import io.moira.config.TestcontainersConfig;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.domain.user.UserRepository;
import io.moira.interfaces.graphql.dto.UserView;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@EnableDgsTest
@Import(TestcontainersConfig.class)
class UserQueryTests {

  @Autowired DgsQueryExecutor dgsQueryExecutor;
  @Autowired UserRepository userRepository;

  @Test
  @AutoParams
  void getUser(UUID id, String email, String password) {
    userRepository.save(new User(new UserId(id), email, password, OffsetDateTime.now()));

    GraphQLQueryRequest request =
        new GraphQLQueryRequest(
            new UserGraphQLQuery.Builder().id(id.toString()).build(),
            new UserProjectionRoot<>().id().email());
    UserView result =
        dgsQueryExecutor.executeAndExtractJsonPathAsObject(
            request.serialize(), "data.user", UserView.class);

    assertEquals(id.toString(), result.id());
    assertEquals(email, result.email());
  }

  @Test
  void getUser_userDoesNotExist_returnError() {
    String id = UUID.randomUUID().toString();

    GraphQLQueryRequest request =
        new GraphQLQueryRequest(new UserGraphQLQuery.Builder().id(id).build());
    var result = dgsQueryExecutor.execute(request.serialize());

    assertNotEquals(0, result.getErrors().size());
  }
}
