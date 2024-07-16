FROM tiangolo/nginx-rtmp

# Dosyayı kopyala
COPY ffmpeg-6.1.1.tar.bz2 /usr/src/

# Çalışma dizinini değiştir
WORKDIR /usr/src/

# Gerekli paketleri yükle
RUN apt-get update && \
    apt-get install -y nasm yasm libx264-dev libx265-dev && \
    rm -rf /var/lib/apt/lists/*

# Dosyayı çıkar ve ffmpeg'i derle ve yükle
RUN tar -xf ffmpeg-6.1.1.tar.bz2 && \
    cd ffmpeg-6.1.1 && \
    ./configure --enable-libx264 --enable-libx265 --enable-gpl && \
    make -j $(nproc) && \
    make install
RUN mkdir -p /tmp/hls && \
    chown -R www-data:www-data /tmp/hls && \
    chmod -R 755 /tmp/hls
COPY nginx.conf /etc/nginx/nginx.conf
COPY index.html /www/

WORKDIR /
CMD ["nginx", "-g", "daemon off;"]


