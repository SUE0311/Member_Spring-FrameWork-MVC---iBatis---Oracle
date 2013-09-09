/* member33 */

create table member33(
 	mem_code int unique not null,  		/*아이디 중복 구분 필드*/
 								 		/* unique 제약조건은 중복 자료 금지,null 허용 */
 	mem_id varchar(30) primary key, 	/*회원 아이디*/
 	mem_pwd varchar(30) not null, 		/*회원 비밀번호*/
 	mem_name varchar(20) not null, 		/*회원 이름*/
 	mem_zip varchar(3) not null, 		/*우편번호1*/
 	mem_zip2 varchar(3) not null, 		/*우편번호2*/
 	mem_addr varchar(100) not null, 	/*주소1*/	
 	mem_addr2 varchar(100) not null, 	/*주소2*/
 	mem_phone varchar(30) not null, 	/*연락처*/	
 	mem_email varchar(100) not null, 	/*이메일*/
 	mem_regdate date, 					/*회원등록 날짜*/
 	mem_state int, 						/*가입회원 1,탈퇴회원 2 */
 	mem_delcont varchar(4000), 			/*탈퇴사유*/
	 mem_deldate date 					/*탈퇴날짜*/
);

/***** member13테이블의 member33__seq 시퀀스 생성 *****/
create sequence member33_seq
       increment by 1 start with 1 nocache;

drop sequence member33_seq;

insert into member33 
	(mem_code,mem_id,mem_pwd,mem_name,mem_zip,mem_zip2,
	mem_addr,mem_addr2,mem_phone,mem_email,mem_regdate,mem_state)
values(member33_seq.nextval,'aaaaa','77777','홍길동','745','850',
	'서울시 마포구 대흥동','중앙 정보 처리 학원','010-777-7777',
	'hone@naver.com',sysdate,1);

select * from member33;






