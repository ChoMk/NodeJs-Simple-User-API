# NodeJs-Simple User API



## 소개
> android, node js를 이용하여 User API를 만들어 보자.



## 서버


### user insert

> 아이디, 이름, 나이를 입력 받아서 서버로 보내고 서버에서는 sql에 저장. 추가로 id중복시 입력 거부



### user delete

> 유저 id를 입력 받아서 서버에 저장되어 있는 유저 정보를 삭제.


### user all view


> 저장되어 있는 모든 유저 정보를 볼 수 있다.



### user search

> 특정 유저 아이디를 입력시 정보를 받을 수 있다.

## 클라이언트

### 송수신

> retrofit2를 이용하여 api 인터페이스를 구축하여 송수신

### 최적화

> dagger2를 이용하여 DI를 적용하여 API Repo class를 매번 선언하는 것을 줄임
> xml이 깊은 트리를 만들지 못하도록 최대한 트리를 평평하게 구성하려고 노력

### 개발환경
> Android Studio, node js

### 참여자
> 조명기 ChoMK
