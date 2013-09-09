/* guest33.sql */

create table guest33(
  guest_no int primary key,				/*���� ����*/
  guest_name varchar2(30) not null, 	/*���� �۾���*/
  guest_title varchar2(200) not null, 	/*���� ����*/
  guest_cont varchar2(4000) not null, 	/*���� ����*/
  guest_pwd varchar2(30) not null,		/*���� ��й�ȣ*/
  guest_hit int default 0, 				/*���� ��ȸ��*/
  guest_regdate date					/*���� �����*/
);

/*���� ������ ����*/
create sequence guest33_no_seq
       increment by 1 start with 1 nocache;
       
select * from GUEST33;       