FROM ubuntu-java

WORKDIR /usr/local/bin

ENV version=2.2.2

ENV jdbcurl=jdbc:postgresql://database-1.ccgn5kdjalb2.ap-south-1.rds.amazonaws.com:5432/postgres

ENV dbuser=postgres

ENV dbpass=12345678

COPY ./target/Management.jar .

ENTRYPOINT [ "java","-jar","Management.jar"]