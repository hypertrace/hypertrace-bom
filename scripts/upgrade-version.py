import sys
import tomlkit

# key: github repository in the format org/repository
# value: version.ref for the corresponding repository in gradle/libs.versions.toml
REPOSITORY_TOML_KEYS = {
  "hypertrace/java-grpc-utils": "hypertrace-grpcutils",
  "hypertrace/service-framework": "hypertrace-framework",
  "hypertrace/kafka-streams-framework": "hypertrace-kafka",
  "hypertrace/config-service": "hypertrace-configservice",
}

repository = sys.argv[1]
version = sys.argv[2]

toml_file = 'gradle/libs.versions.toml'

with open(toml_file, 'r') as f:
    toml_data = tomlkit.load(f)

toml_key = REPOSITORY_TOML_KEYS[repository]
toml_data['versions'][toml_key] = version

with open(toml_file, 'w') as f:
    tomlkit.dump(toml_data, f)
