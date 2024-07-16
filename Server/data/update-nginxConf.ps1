Set-ExecutionPolicy Bypass -Scope Process -Force
cd C:\Users\yusuf\OneDrive\Masaüstü\Server\rtmp
docker cp nginx.conf rtmp_server:/etc/nginx/nginx.conf
docker cp index.html rtmp_server:/www/index.html
docker exec -it rtmp_server nginx -s reload
