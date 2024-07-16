Set-ExecutionPolicy Bypass -Scope Process -Force
cd C:\Users\yusuf\OneDrive\Masaüstü\Server\rtmp
docker cp nginx.conf rtmp_server:/etc/nginx/nginx.conf
docker cp ffmpeg_push.sh rtmp_server:/etc/nginx/ffmpeg_push.sh
docker exec rtmp_server chmod +x /etc/nginx/ffmpeg_push.sh
docker cp create_directory.sh rtmp_server:/etc/nginx/create_directory.sh
docker exec rtmp_server chmod +x /etc/nginx/create_directory.sh
docker cp index.html rtmp_server:/www/index.html
docker exec -it rtmp_server nginx -s reload
