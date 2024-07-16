#!/bin/bash

# Parametreleri al
STREAM_NAME="$1"
KEY="$2"

# FFMPEG komutunu çalıştır
/usr/local/bin/ffmpeg -threads 1 -f flv -i "rtmp://localhost:1935/live/$STREAM_NAME?key=$KEY" -c:v libx264 -crf 22 -c:a aac -ar 44100 -filter_complex "[0:v]scale=w=480:h=360[v0];[0:a]aformat=sample_rates=44100[a0]" -map "[v0]" -map "[a0]" -b:v 100k -maxrate 120k -bufsize 200k -f hls -hls_time 3 -hls_flags independent_segments -hls_list_size 10 -master_pl_name "/tmp/hls/$STREAM_NAME/_144p.m3u8" -y "/tmp/hls/$STREAM_NAME/_144p.m3u8" 2>"/tmp/hls/LOG_144p.txt"
