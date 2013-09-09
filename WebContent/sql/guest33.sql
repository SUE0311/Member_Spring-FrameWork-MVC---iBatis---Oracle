/* guest33.sql */

create table guest33(
  guest_no int primary key,				/*방명록 연번*/
  guest_name varchar2(30) not null, 	/*방명록 글쓴이*/
  guest_title varchar2(200) not null, 	/*방명록 제목*/
  guest_cont varchar2(4000) not null, 	/*방명록 내용*/
  guest_pwd varchar2(30) not null,		/*방명록 비밀번호*/
  guest_hit int default 0, 				/*방명록 조회수*/
  guest_regdate date					/*방명록 등록일*/
);

/*방명록 시퀀시 생성*/
create sequence guest33_no_seq
       increment by 1 start with 1 nocache;
       
select * from GUEST33;       