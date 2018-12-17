
# Run DB

[Docker HUB for oracle db](https://hub.docker.com/r/wnameless/oracle-xe-11g/)

`docker run -d -p 49161:1521 wnameless/oracle-xe-11g`

    username: system
    password: oracle
    
JDBC url: `jdbc:oracle:thin:@localhost:49161:xe`


Before start run:
`mvnw.cmd clean install` on pom.xml to download all dependencies


