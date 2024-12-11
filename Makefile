all : up

up :
	mkdir -p $(HOME)/data
	chmod 777 ./db/conf/postgresql.conf
	chmod 777 $(HOME)/data
	#chown -R postgres:postgres ./data
	docker-compose -f docker-compose-dev.yml up -d --build

# prod-up :
# 	mkdir -p $(HOME)/data
# 	docker-compose -f docker-compose-prod.yml up -d --build

down :
	docker-compose -f docker-compose-dev.yml down

# prod-down :
# 	docker-compose -f docker-compose-prod.yml down

clean :
	docker-compose -f docker-compose-dev.yml down -v --rmi all

fclean : clean
	rm -rf ./web/client_shared
	docker volume prune -f
	docker image prune -f
	docker system prune -f

# prod-clean :
# 	docker-compose -f docker-compose-prod.yml down -v --rmi all

# prod-fclean : prod-clean
# 	rm -rf ./web/client_shared
# 	docker volume prune -f
# 	docker image prune -f
# 	docker system prune -f

all_fclean : clean delete_db
	docker volume prune -f
	docker image prune -f
	docker system prune -f

ls :
	docker ps -a

api:
	docker exec -it hexagonal-app /bin/bash

db:
	docker exec -it db /bin/bash

api_log:
	docker logs -f hexagonal-app

db_log:
	docker logs -f db

delete_db:
	rm -rf /data/*

re : down up
prod-re : prod-fclean prod-up

.PHONY : all up down clean fclean re
