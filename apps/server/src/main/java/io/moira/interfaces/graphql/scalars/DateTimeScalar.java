package io.moira.interfaces.graphql.scalars;

import com.netflix.graphql.dgs.DgsScalar;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@DgsScalar(name = "DateTime")
public class DateTimeScalar implements Coercing<OffsetDateTime, String> {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  @Override
  public @Nullable String serialize(@NonNull Object dataFetcherResult)
      throws CoercingSerializeException {
    OffsetDateTime dateTime = (OffsetDateTime) dataFetcherResult;
    return dateTime.format(FORMATTER);
  }

  @Override
  public @Nullable OffsetDateTime parseValue(@NonNull Object input)
      throws CoercingParseValueException {
    return OffsetDateTime.parse(input.toString(), FORMATTER);
  }

  @Override
  public @Nullable OffsetDateTime parseLiteral(@NonNull Object input)
      throws CoercingParseLiteralException {
    if (!(input instanceof StringValue)) {
      throw new CoercingParseLiteralException("Expected a StringValue.");
    }

    String value = ((StringValue) input).getValue();
    return parseValue(value);
  }
}
