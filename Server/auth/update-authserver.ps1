Set-ExecutionPolicy Bypass -Scope Process -Force
cd C:\Users\yusuf\OneDrive\Masaüstü\Server\auth
docker cp server.js auth_server:/usr/src/app/server.js
docker cp db.js auth_server:/usr/src/app/db.js
docker cp db.js auth_server:/usr/src/app/user.js
docker exec -it auth_server -s reload
