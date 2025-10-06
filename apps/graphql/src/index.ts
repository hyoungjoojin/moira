import { GraphQLObjectType, GraphQLSchema, printSchema } from "graphql";
import { UserMutation, UserQuery } from "./schema/index.js";
import { lstatSync, writeFile } from "fs";
import { exit } from "process";

if (process.argv.length < 3) {
  console.error("[!] The output directory must be provided as an argument");
  console.log("[*] Usage: node index.js [directory ...]");
  exit(-1);
}

for (let i = 2; i < process.argv.length; i++) {
  const dir = process.argv[i];
  if (!dir) {
    console.log(`[!] Provided argument ${dir} is undefined`);
    exit(-1);
  }

  try {
    const stats = lstatSync(dir);
    if (!stats.isDirectory()) {
      throw new Error();
    }
  } catch (e) {
    console.log(`[!] Provided argument ${dir} is not a valid directory`);
    exit(-1);
  }
}

const schema = new GraphQLSchema({
  query: new GraphQLObjectType({
    name: "Query",
    fields: {
      ...UserQuery,
    },
  }),
  mutation: new GraphQLObjectType({
    name: "Mutation",
    fields: {
      ...UserMutation,
    },
  }),
});

console.log("[*] Generated GraphQL schema");

for (let i = 2; i < process.argv.length; i++) {
  const outDir = process.argv[i];

  console.log(`[*] Writing GraphQL schema file to ${outDir}/schema.graphql`);
  writeFile(`${outDir}/schema.graphql`, printSchema(schema), (err) => {
    if (err) {
      console.log(
        `[!] Failed to write schema file to ${outDir} due to error ${err.message}`,
      );
    } else {
      console.log(`[+] Successfully wrote schema file`);
    }
  });
}
