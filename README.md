# TransitPlanner
운행시간을 반영한 대중교통 경로 계산 서비스입니다.

## 목적
네이버 지도, 카카오맵 등 지도 앱에서는 버스/지하철에 대한 실시간 위치정보 서비스를 제공하고, 그를 활용한 최적 경로 추천 서비스를 제공합니다.

그러나 KTX, 고속/시외버스 등에 대해서는 단순 소요시간만 표시되기 때문에 운행정보를 직접 계산해야 합니다.

예를들어 경희대학교 국제캠퍼스에서 강원도 정선 시외버스터미널까지 길찾기 기능을 사용하면, 수원-원주행 시외버스(1시간 40분)와 원주-정선행 시외버스(1시간 16분) 노선을 추천해 줍니다.

그러나 원주->정선행은 하루 4대뿐인 노선으로써 정확히 시간을 맞춰 환승하지 않는 이상 몇 시간씩 대기해야 합니다.

이처럼 지도 앱의 예상시간과 추천 경로를 신뢰할 수 없기 때문에, 고속/시외버스 및 열차 시간표를 반영할 수 있는 경로 계산 서비스를 기획하게 되었습니다.

## 구조
- Web Server: Spring Framwork
  - TailwindCSS
  - Thymeleaf
- Docker: https://hub.docker.com/repository/docker/solidcitadel/transitplanner-webserver/general
- DB: MySQL
