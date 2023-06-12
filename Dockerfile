# Builder stage
FROM ubuntu:latest as builder

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Set working directory
WORKDIR /usr/src/app

# Copy the Maven build context to the builder image
COPY . .

# Build the JAR and dependencies
RUN mvn clean package -DskipTests

# Final image
FROM ubuntu:latest

# Install required dependencies
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk curl jq

# Set working directory
WORKDIR /usr/app

# Copy the JAR and dependencies from the builder image
COPY --from=builder /usr/src/app/target/selenium-docker.jar .
COPY --from=builder /usr/src/app/target/selenium-docker-tests.jar .
COPY --from=builder /usr/src/app/target/libs ./libs

# Add suite files
COPY google.xml google.xml
COPY facebook.xml facebook.xml

# Add health check script
#"C:\Tools\Selenium-Docker\healthcheck.sh"
COPY healthcheck.sh healthcheck.sh

# Make the health check script executable
RUN chmod +x healthcheck.sh

# Set the entrypoint
ENTRYPOINT ["sh", "healthcheck.sh"]
