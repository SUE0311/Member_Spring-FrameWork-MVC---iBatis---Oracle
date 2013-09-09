/* member33 */

create table member33(
 	mem_code int unique not null,  		/*���̵� �ߺ� ���� �ʵ�*/
 								 		/* unique ���������� �ߺ� �ڷ� ����,null ��� */
 	mem_id varchar(30) primary key, 	/*ȸ�� ���̵�*/
 	mem_pwd varchar(30) not null, 		/*ȸ�� ��й�ȣ*/
 	mem_name varchar(20) not null, 		/*ȸ�� �̸�*/
 	mem_zip varchar(3) not null, 		/*�����ȣ1*/
 	mem_zip2 varchar(3) not null, 		/*�����ȣ2*/
 	mem_addr varchar(100) not null, 	/*�ּ�1*/	
 	mem_addr2 varchar(100) not null, 	/*�ּ�2*/
 	mem_phone varchar(30) not null, 	/*����ó*/	
 	mem_email varchar(100) not null, 	/*�̸���*/
 	mem_regdate date, 					/*ȸ����� ��¥*/
 	mem_state int, 						/*����ȸ�� 1,Ż��ȸ�� 2 */
 	mem_delcont varchar(4000), 			/*Ż�����*/
	 mem_deldate date 					/*Ż��¥*/
);

/***** member13���̺��� member33__seq ������ ���� *****/
create sequence member33_seq
       increment by 1 start with 1 nocache;

drop sequence member33_seq;

insert into member33 
	(mem_code,mem_id,mem_pwd,mem_name,mem_zip,mem_zip2,
	mem_addr,mem_addr2,mem_phone,mem_email,mem_regdate,mem_state)
values(member33_seq.nextval,'aaaaa','77777','ȫ�浿','745','850',
	'����� ������ ���ﵿ','�߾� ���� ó�� �п�','010-777-7777',
	'hone@naver.com',sysdate,1);

select * from member33;






