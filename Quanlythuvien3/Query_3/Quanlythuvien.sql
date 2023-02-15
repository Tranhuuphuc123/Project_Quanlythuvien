create database Quanlythuvien2
use Quanlythuvien2



-- bang sach van hoc
create table ListSach(
  maSach varchar(50) not null primary key,
  tenSach varchar(200) not null,
  tacGia varchar(200) not null,
  maLoai varchar(100) not null,
  giaSach Double not null,
  soLuong int not null
)

ALTER TABLE ListSach ADD CONSTRAINT FK FOREIGN KEY(maLoai) REFERENCES Maloaisach(maLoai);
alter table ListSach drop constraint FK

-- hien thi maSach theo thu tu
select maSach from ListSach order by maSach

-- tạo bang ma loai
create table Maloaisach(
  maLoai varchar(100) not null primary key,
  tenLoai varchar(200) not null
)

-- truy van 
select * from ListSach
select * from Maloaisach

-- them du lieu
insert into ListSach
values('MS01','Truyen doc', 'Huu Phuc','ML01', 300, 200),
      ('MS02','Ban toi', 'Ngoc phuong','ML02', 255, 200),
      ('MS03','Thuong thuc doi song', 'Rowsling','ML03', 500, 100),
      ('MS04','Toi la ai', 'David', 'ML04',100, 20),
      ('MS05','Yeu la song', 'Nagato','ML01', 220, 150)

update ListSach set soLuong =150 where maSach='MS05'
insert into ListSach
values('MS06','Truyen doc', 'Huu Phuc','ML01', 300, 200)



insert into Maloaisach
value('ML01','Sách Công nghệ'),
     ('ML02','Sách Văn Học'),
     ('ML03', 'Sách KHXH'),
     ('ML04','Sách Địa Lý')


insert into Maloaisach
value('ML08','Sách Tội Phạm Học')


DELETE  from ListSach where maSach='MS06';
select * from ListSach    
INSERT INTO ListSach VALUES
('MS07', 'NEWNEWNEW', 'TG', 'ML01', 100, 100)


select * from Maloaisach
select * from ListSach


-- co so du lieu dangg ky ban doc
create table ListBandoc(
  maBandoc varchar(100) not null primary key,
  tenBandoc varchar(200) not null,
  CMND varchar(100) not null,
  gioiTinh varchar(50) not null,
  ngayDangky varchar(100) not null,
  ngayHethan varchar(100) not null
)

-- hien thi mabandoc
select maBandoc from ListBandoc

insert into ListBandoc
values('MBD01','Tran Huu Phuc','3624526259', 'Nam','22-09-2022','22-09-2023'),
	  ('MBD02','Tran Anh Tuan','3624526259', 'Nam','22-09-2022','22-09-2023'),
      ('MBD03','Tran Ngoc Nhi','3624526259', 'Nu','22-09-2022','22-09-2023'),
      ('MBD04','Tran yen Linh','3624526259', 'Nu','22-09-2022','22-09-2023')

select * from ListBandoc
delete from ListBandoc where =""
-- tao bang quanlymuontra
create table Quanlymuontra(
   maSach varchar(100) not null,
   maBandoc varchar(100) not null ,
   ngayMuon varchar(100) not null,
   ngayTra varchar(100) not null,
   tinhTrang varchar(50) not null,
   primary key(maSach, maBandoc)
)

-- khoa ngoai
alter table Quanlymuontra add constraint fk2 foreign key(maSach) references ListSach(maSach)
alter table Quanlymuontra add constraint fk3 foreign key(maBandoc) references ListBandoc(maBandoc)
-- them du lieu

insert into Quanlymuontra
values ('MS01','MBD01','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS02','MBD02','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS03','MBD03','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS04','MBD04','22/12/2022','13/03/2023', 'Đã trả'),
       ('MS05','MBD05','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS06','MBD06','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS07','MBD01','22/12/2022','13/03/2023', 'Đã trả'),
       ('MS08','MBD02','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS01','MBD02','22/12/2022','13/03/2023', 'Còn mượn'),
       ('MS01','MBD04','22/12/2022','13/03/2023', 'Còn mượn')
       
update Quanlymuontra set tinhTrang = 'Còn mượn' where maSach = 'MS08'

insert into Quanlymuontra
values('MS02','MBD04','29/01/2023','29/03/2023','Còn mượn')

delete from Quanlymuontra where maSach ='MS09'
select * from Quanlymuontra



-- chuc nang tiem kiem tyhong qua cau lenh joins trong sql
create view Quanlytiemkiem
as
select MT.maSach, tenSach, LBD.maBandoc, tenBandoc, ngayMuon, ngayTra, tinhTrang
from Quanlymuontra MT join ListSach LS on MT.maSach = LS.maSach
                  join ListBandoc LBD on MT.maBandoc = LBD.maBandoc
    
 -- hien thi table view qQuanlytiemkiem
 select * from Quanlytiemkiem
 select * from Quanlytiemkiem where maBandoc like '%MB%'
 update Quanlytiemkiem set tinhTrang = 'Đã trả' where maSach ='MS09'
 
 
-- taoj bang Login
create table Login(
  User varchar(100) not null primary key,
  Gmail varchar(200) not null,
  Password varchar(100) not null,
  Confirm_Pass varchar(100) not null
) 

insert into Login
values('phucth','Cantho1995ct@gmail.com','Huuphuc1995ct@','Huuphuc1995ct@'),
      ('nhiNP','NhiNguyen1995ct@gmail.com','Nhi123@','Nhi123@')
      
   select * from Login   
   delete from Login where User ='PhuongTT'