-- 샘플 REDIS 임포트 방법
redis-cli -h localhost -p 6379 < sample_fs.redis

-- SN 데이터 임포트
redis-cli -h localhost -p 6379 < sample_sn.redis

_or_

redis-cli -h localhost -p 6379 < sample_sn_html.redis
