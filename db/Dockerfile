FROM postgres:16.0

# 환경변수 정의 (환경변수는 Docker Compose에서 전달받음)
ENV POSTGRES_DB=$POSTGRES_DB
ENV POSTGRES_USER=$POSTGRES_USER
ENV POSTGRES_PASSWORD=$POSTGRES_PASSWORD

# PostgreSQL 서버 실행을 위한 설정 파일 추가
COPY conf/postgresql.conf /etc/postgresql/postgresql.conf
COPY conf/pg_hba.conf /etc/postgresql/pg_hba.conf

#RUN chmod 777 /var/lib/postgresql/data/postgresql.conf
#
EXPOSE 5432
#
#USER postgres
CMD ["postgres"]

# CMD ["tail", "-f", "/dev/null"]