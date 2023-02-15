-- tạo dattabase Quanlythuvien
create database Quanlythuvien
use Quanlythuvien

create table Quanlysach(
  maSach varchar(100) not null,
  tenSach varchar(100) not null,
  loaiSach varchar(100) not null,
  nhaXuatBan varchar(100) not null,
  tacGia varchar(100) not null,
  soLuong int not null  
)

select * from Quanlysach

-- thêm dữ liệu
insert into Quanlysach(maSach, tenSach, loaiSach, nhaXuatBan, tacGia, soLuong )
values('MA01','Sach lap trinh', 'Cong nghe', 'Nha sach cantho','Tran Huu Phuc', 200),
       ('MA02','Dia chat hoc', 'Dia ly', 'Nha sach cantho','Tran Kim Dong', 100),
       ('MA03','Bac ba phi', 'vawn hoc', 'Nha sach TP.HCM','Hoa Vi Loi', 150)

insert into Quanlysach(maSach, tenSach, loaiSach, nhaXuatBan, tacGia, soLuong )
values('MA04','Binh phap ton tu', 'Van hoc', 'Nha sach cantho','Tran Huu Phuc', 200),
       ('MA05','Microsoft', 'Cong nghe', 'Nha sach cantho','Tran Thai son', 200),
       ('MA06','Anh van toeic', 'Van hoc', 'Nha sach TP.HCM','Duong boi ninh', 150)
       
insert into Quanlysach(maSach, tenSach, loaiSach, nhaXuatBan, tacGia, soLuong )
values('MA09','Binh phap ton tu', 'Van hoc', 'Nha sach cantho','Tran Huu Phuc', 200),
       ('MA10','Microsoft', 'Cong nghe', 'Nha sach cantho','Tran Thai son', 200),
       ('MA11','Anh van toeic', 'Van hoc', 'Nha sach TP.HCM','Duong boi ninh', 150)
-- lenh xoa row
DELETE from Quanlysach where STT = 4
select * from Quanlysach


-- tạo bảng bạn đọc 
create table Quanlybandoc(
   maBandoc varchar(100) not null primary key,
   tenBandoc varchar(100) not null,
   diaChi varchar(200) not null,
   CMND varchar(100) not null,
   namSinh int not null,
   ngayDangky date
)

insert into Quanlybandoc(maBandoc, tenBandoc, diaChi, CMND, namSinh, ngayDangky )
values('BD01','Luu ton tu', 'Can tho','321569', 1995, '2022-02-12'),
       ('BD02','Yen nhi','TP.HCM','256912', 2000,'2022-02-12'),
       ('BD03','Nguyen ngoc phuong', 'Long An', '5469803',1993,'2022-03-23')
       
       select * from Quanlybandoc