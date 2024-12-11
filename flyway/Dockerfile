FROM flyway/flyway:11.0.1

# Flyway 명령어를 환경 변수와 함께 실행하도록 설정
ENTRYPOINT ["sh", "-c", "flyway -url=jdbc:postgresql://db:5432/$POSTGRES_DB -user=$POSTGRES_USER -password=$POSTGRES_PASSWORD migrate"]