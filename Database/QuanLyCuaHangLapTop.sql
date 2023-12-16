
CREATE DATABASE QuanLyCuaHangLaptop
USE QuanLyCuaHangLaptop
DROP DATABASE QuanLyCuaHangLaptop

CREATE TABLE DongSP (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('DSP'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
ALTER TABLE dbo.DongSP ADD TrangThai INT DEFAULT 0
ALTER TABLE dbo.DongSP ADD Ma AS ('DSP'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL
INSERT INTO DongSP(Ma, Ten) VALUES ('DSP05', 'Acer')
INSERT INTO DongSP(Ma, Ten) VALUES ('DSP01', 'Dell')
INSERT INTO DongSP(Ma, Ten) VALUES ('DSP02', 'MSI')
INSERT INTO DongSP(Ma, Ten) VALUES ('DSP03', 'HP')
INSERT INTO DongSP(Ma, Ten) VALUES ('DSP04', 'MacBook')
SELECT * FROM dbo.DongSP

CREATE TABLE SanPham (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('SP'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(50),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO SanPham(Ma, Ten, TrangThai) VALUES ('SP05', 'Laptop MacBook Pro 16 M1 Max', 0)
INSERT INTO SanPham(Ma, Ten, TrangThai) VALUES ('SP01', 'Laptop Acer Aspire 3 A315-56-38B1', 0)
INSERT INTO SanPham(Ma, Ten, TrangThai) VALUES ('SP02', 'Laptop Dell Vostro 3520 5M2TT2', 0)
INSERT INTO SanPham(Ma, Ten, TrangThai) VALUES ('SP03', 'Laptop MSI GS63 Thin 11SC 664VN', 0)
INSERT INTO SanPham(Ma, Ten, TrangThai) VALUES ('SP04', 'Laptop HP 14s-dq2644TU 7C0W6PA', 0)
SELECT * FROM dbo.SanPham

CREATE TABLE NSX (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('NSX'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
QuocGia NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO NSX(Ma, Ten, QuocGia, TrangThai) VALUES ('NSX05', N'CT Acer', N'Đài Loan', 0)
INSERT INTO NSX(Ma, Ten, QuocGia, TrangThai) VALUES ('NSX01', N'CT Dell', N'Hoa Kỳ', 0)
INSERT INTO NSX(Ma, Ten, QuocGia, TrangThai) VALUES ('NSX02', N'CT HP', N'Mỹ', 0)
INSERT INTO NSX(Ma, Ten, QuocGia, TrangThai) VALUES ('NSX03', N'CT MSI', N'Đài Loan', 0)
INSERT INTO NSX(Ma, Ten, QuocGia, TrangThai) VALUES ('NSX04', N'CT Apple', N'Mỹ', 0)
SELECT * FROM dbo.NSX

CREATE TABLE RAM (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('RAM'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO RAM(Ma, Ten, TrangThai) VALUES ('RAM05', 'RAM 8GB DDR4', 0)
INSERT INTO RAM(Ma, Ten, TrangThai) VALUES ('RAM01', 'RAM 16GB DDR4', 0)
INSERT INTO RAM(Ma, Ten, TrangThai) VALUES ('RAM02', 'RAM 16GB LPDDR5', 0)
INSERT INTO RAM(Ma, Ten, TrangThai) VALUES ('RAM03', 'RAM 16GB DDR5', 0)
INSERT INTO RAM(Ma, Ten, TrangThai) VALUES ('RAM04', 'RAM 16GB DDR3L', 0)
SELECT * FROM dbo.RAM

CREATE TABLE SSD (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('SSD'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO SSD(Ma, Ten, TrangThai) VALUES ('SSD04', 'SSD 256GB PCle NVMe', 0)
INSERT INTO SSD(Ma, Ten, TrangThai) VALUES ('SSD01', 'SSD 512GB PCle NVMe', 0)
INSERT INTO SSD(Ma, Ten, TrangThai) VALUES ('SSD02', 'SSD 256GB M2 SATA', 0)
INSERT INTO SSD(Ma, Ten, TrangThai) VALUES ('SSD03', 'SSD 512GB M2 SATA', 0)
SELECT * FROM dbo.SSD

CREATE TABLE MauSac (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('MS'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES ('MS05', N'Màu xanh', 0)
INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES ('MS01', N'Màu đen', 0)
INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES ('MS02', N'Màu trắng', 0)
INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES ('MS03', N'Màu xám', 0)
INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES ('MS04', N'Màu bạc', 0)
SELECT * FROM dbo.MauSac

CREATE TABLE CPU (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('CPU'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU01', 'CPU Intel Core i5', 0)
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU02', 'CPU Intel Core i7', 0)
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU03', 'CPU Intel Core i9', 0)
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU04', 'CPU ADM Ryzen 5', 0)
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU05', 'CPU ADM Ryzen 7', 0)
INSERT INTO CPU(Ma, Ten, TrangThai) VALUES ('CPU06', 'CPU ADM Ryzen Threadripper', 0)
SELECT * FROM dbo.CPU

CREATE TABLE ManHinh (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('MH'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
DoPhanGiai VARCHAR(30),
Inch FLOAT,
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO ManHinh(Ma, DoPhanGiai, Inch, TrangThai) VALUES ('MH05', 'FHD 144Hz', 16.0, 0)
INSERT INTO ManHinh(Ma, DoPhanGiai, Inch, TrangThai) VALUES ('MH01', 'FHD IPS ComfyView LED LCD', 14.0, 0)
INSERT INTO ManHinh(Ma, DoPhanGiai, Inch, TrangThai) VALUES ('MH02', 'FHD 120Hz WVA', 15.6, 0)
INSERT INTO ManHinh(Ma, DoPhanGiai, Inch, TrangThai) VALUES ('MH03', 'WQXGA 16:10 IPS PoL 99%DCI-P3', 16.0, 0)
INSERT INTO ManHinh(Ma, DoPhanGiai, Inch, TrangThai) VALUES ('MH04', 'FHD+WVA Anti-Glare 60Hz', 15.6, 0)
SELECT * FROM dbo.ManHinh

CREATE TABLE BaoHanh (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(), 
Ma AS ('BH'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
SoThangBH INT,
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO BaoHanh(Ma, SoThangBH, TrangThai) VALUES ('BH03', 6, 0)
INSERT INTO BaoHanh(Ma, SoThangBH, TrangThai) VALUES ('BH01', 12, 0)
INSERT INTO BaoHanh(Ma, SoThangBH, TrangThai) VALUES ('BH02', 24, 0)
SELECT * FROM dbo.BaoHanh

CREATE TABLE ChucVu (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('CV'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
INSERT INTO ChucVu (Ma, Ten, TrangThai) VALUES ('CV01', N'Quản lý', 0)
INSERT INTO ChucVu (Ma, Ten, TrangThai) VALUES ('CV02', N'Nhân viên', 0)
INSERT INTO ChucVu (Ma, Ten, TrangThai) VALUES ('CV03', N'Thủ kho', 0)
SELECT * FROM dbo.ChucVu

CREATE TABLE KhachHang (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('KH'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
HoTen NVARCHAR(30),
NgaySinh DATE,
Sdt VARCHAR(10),
DiaChi NVARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
SELECT * FROM dbo.KhachHang
INSERT INTO KhachHang (HoTen,  NgaySinh, Sdt, DiaChi, TrangThai)
VALUES (N'Nguyễn Văn Tuấn', '2003-01-01', '0932765463', N'31 Hoàng Quốc Việt', 0)

CREATE TABLE NhanVien (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdCV UNIQUEIDENTIFIER REFERENCES dbo.ChucVu(Id),
Ma AS ('NV'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
HoTen NVARCHAR(30),
GioiTinh NVARCHAR(10),
NgaySinh DATE,
Sdt VARCHAR(10),
DiaChi NVARCHAR(30),
MatKhau VARCHAR(30),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT
);
SELECT * FROM dbo.NhanVien
INSERT INTO NhanVien (IdCV, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, MatKhau, TrangThai)
VALUES ('5F2629E3-D4B9-403B-A132-62C4377FEFFD', N'Nguyễn Văn Tùng', N'Nam', '1998-01-01', '0373654374', N'Hà Nội', '88888888', 1)


CREATE TABLE HoaDon (
NumOrder INT IDENTITY(1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('HD'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
IdKH UNIQUEIDENTIFIER REFERENCES dbo.KhachHang (Id),
IdNV UNIQUEIDENTIFIER REFERENCES dbo.NhanVien (Id),
NgayThanhToan DATE DEFAULT GETDATE(),
KhuyenMai DECIMAL (20,0) DEFAULT 0,
ThanhTien DECIMAL (20,0) DEFAULT 0,
LyDo NVARCHAR(50) DEFAULT 0,
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
ALTER TABLE dbo.HoaDon ADD ThanhTien DECIMAL (20,0) DEFAULT 0
SELECT * FROM dbo.HoaDon
ALTER TABLE dbo.HoaDon ADD NumOrder INT IDENTITY(1,1)
ALTER TABLE dbo.HoaDon ADD Ma AS ('HD'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL

CREATE TABLE ChiTietHD (
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdHD UNIQUEIDENTIFIER REFERENCES dbo.HoaDon(Id),
IdChiTietSP UNIQUEIDENTIFIER REFERENCES dbo.ChiTietSP(Id),
Dongia DECIMAL (20,0) DEFAULT 0,
SoLuong INT DEFAULT 0,
ThanhTien DECIMAL (20,0) DEFAULT 0,
NgayTao DATE DEFAULT GETDATE(), 
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);

SELECT * FROM dbo.HoaDon
ALTER TABLE dbo.ChiTietHD DROP CONSTRAINT 


CREATE TABLE IMeiDaBan (
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IMei VARCHAR(15),
IdChiTietHD UNIQUEIDENTIFIER REFERENCES ChiTietHD (IdHD),
NgayBan DATE DEFAULT GETDATE(),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
SELECT * FROM dbo.IMeiDaBan
INSERT INTO IMeiDaBan (IMei, IdChiTietHD) VALUES (?, ?)


CREATE TABLE ChiTietSP (
NumOrder INT IDENTITY (1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('CTSP'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
IdSP UNIQUEIDENTIFIER REFERENCES dbo.SanPham (Id),
IdNSX UNIQUEIDENTIFIER REFERENCES dbo.NSX (Id),
IdMauSac UNIQUEIDENTIFIER REFERENCES dbo.MauSac (Id),
IdDongSP UNIQUEIDENTIFIER REFERENCES dbo.DongSP (Id),
IdCPU UNIQUEIDENTIFIER REFERENCES dbo.CPU(Id),
IdRAM UNIQUEIDENTIFIER REFERENCES dbo.RAM(Id),
IdSSD UNIQUEIDENTIFIER REFERENCES dbo.SSD(Id),
IdManHinh UNIQUEIDENTIFIER REFERENCES dbo.ManHinh(Id),
IdBH UNIQUEIDENTIFIER REFERENCES dbo.BaoHanh (Id),
CanNang DECIMAL (10, 1),
MoTa NVARCHAR(30),
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 1
);
ALTER TABLE dbo.ChiTietSP ADD NumOrder INT IDENTITY(1,1)
ALTER TABLE dbo.ChiTietSP ADD Ma AS ('CTSP'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL
SELECT * FROM dbo.ChiTietSP
INSERT INTO ChiTietSP (IdSP, IdNSX, IdMauSac, IdDongSP, IdCPU, IdRAM, IdSSD, IdManHinh, IdBH, CanNang, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai)
VALUES ('66E5E69C-EAA1-49AC-9A95-18467676330C', '7C7E5C4D-03D4-4B38-BB7D-F87593552086', '2B4A0D7F-2FE4-49AC-A407-8EEB4FED948D', '0AF0A3AC-B167-41D7-899D-CA5938FC51F2', '09AAAE0A-665D-4C92-B046-6911E01E9E35', '0D045214-43B9-4ACD-A346-CB3D7BCA2AF0', '2A1694AF-670F-407F-A22A-E4CD924005FF', '6A481614-AB9E-4257-A5DF-10B9497BAE73', '9CDB2C32-94CB-4018-A599-1ADBCF24E2EA', 1.6, N'Tốt', 1, 222, 333, 0)
DELETE FROM dbo.ChiTietSP

CREATE TABLE IMei (
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IMei VARCHAR(15) DEFAULT ABS(CHECKSUM(NEWID())) % 900000000000000 + 100000000000000,
IdChiTietSP UNIQUEIDENTIFIER REFERENCES ChiTietSP(Id),
NgayTao DATE DEFAULT GETDATE(),
NgaySua DATE DEFAULT GETDATE(),
TrangThai INT DEFAULT 0
);
SELECT * FROM dbo.IMei
INSERT INTO IMei (IdChiTietSP, TrangThai) VALUES ('5F0FBD46-1FFA-46A1-8A8B-24552CA7AEB6', 0)

CREATE TABLE KhuyenMai(
NumOrder INT IDENTITY(1,1),
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma AS ('MaKM0'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL,
SoTienGiam DECIMAL(20,0) DEFAULT 0,
SoLuong INT,
NgayBatDau DATE,
NgayKetThuc DATE,
TrangThai INT DEFAULT 1
);
ALTER TABLE dbo.KhuyenMai ADD Ma AS ('MaKM0'+CONVERT([VARCHAR](10),NumOrder)) PERSISTED NOT NULL


INSERT INTO KhuyenMai(Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc)
VALUES ('Ma01KM100', 100000, 20, '2023-07-25', '2023-07-27')


SELECT NV.Ma AS 'Ma', NV.MatKhau AS 'MatKhau', CV.Ten AS 'VaiTro' FROM dbo.NhanVien NV JOIN dbo.ChucVu CV
ON CV.Id = NV.IdCV

DELETE FROM NhanVien
DELETE FROM ChucVu

SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.Ten AS 'Ten', NV.TenDem AS 'TenDem', NV.Ho AS 'Ho', NV.GioiTinh AS 'GioiTinh', 
NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' 
FROM dbo.NhanVien NV JOIN dbo.ChucVu CV
ON CV.Id = NV.IdCV

DELETE FROM dbo.ChiTietSP
SELECT * FROM dbo.ChiTietSP
INSERT INTO ChiTietSP (IdSP, IdNSX, IdMauSac, IdDongSP, IdCPU, IdRAM, IdSSD, IdManHinh, IdBH, CanNang, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai)
VALUES ('75BEA465-8902-44C7-A8D3-7C04A5347DA4', '4CD3DA5D-3D49-441B-9213-C3737E5E1DD9', 'A4872C32-A810-4805-9281-FE1651693B38', '55690118-164B-4724-A6BB-30BB60A71877', '2CBA3EC2-B712-4DE0-B95C-208EF078F602', '8F4AB048-FEDB-45D6-9A24-C35771492B3C', 'C8564CCE-2DA6-450D-A3D5-DF80BFA7A928', '2C079563-4A53-4264-A42E-85A247B7D85A', 'B662D76C-0027-44C2-AEBE-7FD89E5B5E0C', 1.6, N'Phù hợp với sinh viên', 1, 21000000, 23000000, 0)

SELECT * FROM dbo.SanPham
SELECT * FROM dbo.NSX
SELECT * FROM dbo.MauSac
SELECT * FROM dbo.DongSP
SELECT * FROM dbo.CPU
SELECT * FROM dbo.RAM
SELECT * FROM dbo.SSD
SELECT * FROM dbo.ManHinh
SELECT * FROM dbo.BaoHanh

SELECT * FROM dbo.ChiTietSP

SELECT * FROM dbo.KhachHang


--Lấy ra hóa đơn chưa thanh toán
SELECT HD.Id AS 'Id', HD.Ma AS 'Ma', HD.IdKH AS 'IdKH', KH.Ma AS 'MaKH', NV.Id AS 'IdNV', NV.Ma AS 'MaNV', HD.NgayTao AS 'NgayTao', HD.NgaySua AS 'NgaySua', HD.NgayThanhToan AS 'NgayThanhToan', HD.TrangThai AS 'TrangThai' 
FROM dbo.HoaDon HD JOIN dbo.KhachHang KH
ON KH.Id = HD.IdKH JOIN dbo.NhanVien NV
ON NV.Id = HD.IdNV
WHERE HD.TrangThai = 0
ORDER BY HD.Ma DESC
DELETE FROM dbo.HoaDon


--Lấy danh sách chiTietSP
SELECT * FROM dbo.ChiTietSP
SELECT CTSP.Id AS 'Id', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac', 
RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.SoThangBH AS 'BaoHanh', CTSP.SoLuongTon AS 'SoLuong', CTSP.TrangThai AS 'TrangThai'
FROM dbo.ChiTietSP CTSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.RAM 
ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD
ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU
ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX
ON NSX.Id = CTSP.IdNSX
WHERE DSP.Ten = ?

--Lấy danh sách chiTietSP theo trạng thái
SELECT * FROM dbo.ChiTietSP CTSP JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.RAM 
ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD
ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU 
ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.NSX 
ON NSX.Id = CTSP.IdNSX
WHERE CTSP.TrangThai = 0

UPDATE dbo.ChiTietSP SET TrangThai = 1

--Lấy thông tin khách hàng theo sdt hoặc email
SELECT Ho, TenDem, Ten, Email, Sdt FROM dbo.KhachHang WHERE Sdt = '0' OR Email = 'nguyentuan2003@gmail.com'
DELETE FROM dbo.KhachHang WHERE Ma = 'KH03'
SELECT * FROM dbo.KhachHang


--Tìm imei theo tên dongSP
SELECT CTSP.Id AS 'Id', I.Id AS 'IdIMei', I.IMei AS 'IMei', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac', 
RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.SoThangBH AS 'BaoHanh', I.TrangThai AS 'TrangThai'
FROM dbo.ChiTietSP CTSP JOIN dbo.IMei I
ON I.IdChiTietSP = CTSP.Id JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.RAM 
ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD
ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU
ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX
ON NSX.Id = CTSP.IdNSX
WHERE I.TrangThai = 0 AND DSP.Ten = 'Dell'


--Lấy id khách hàng theo sdt
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.KhachHang 
SELECT * FROM dbo.NhanVien
SELECT Id FROM dbo.KhachHang WHERE Sdt = '0932765463'
SELECT Id FROM dbo.NhanVien WHERE Ma = 'NV02'
DELETE FROM dbo.HoaDon

--Load chitietHD
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD
SELECT Id FROM dbo.HoaDon WHERE Ma = 'HD25'
SELECT * FROM dbo.ChiTietSP

--Lấy danh sách chitietHD(Giỏ hàng) theo IdHD
--lấy danh sách 
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD
SELECT * FROM dbo.ChiTietSP
SELECT CTSP.Id AS 'IdChiTietSP', CTSP.IdSP AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', CTHD.SoLuong AS 'SoLuong', CTHD.Dongia AS 'DonGia', CTHD.ThanhTien AS 'ThanhTien', CTHD.TrangThai AS 'TrangThai'
FROM dbo.ChiTietHD CTHD JOIN dbo.ChiTietSP CTSP
ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP
WHERE CTHD.TrangThai = 0 AND CTHD.IdHD = '935EA306-8245-466B-95B1-C0FFE7A6F2C6'


--chitietSP có số lượng dưới 5
SELECT ChiTietSP.Id FROM dbo.ChiTietSP
WHERE SoLuongTon < 6

--Tìm imei theo idChiTietSP
SELECT * FROM dbo.ChiTietSP JOIN dbo.IMei
ON IMei.IdChiTietSP = ChiTietSP.Id 
WHERE IMei = '100000990945894'
SELECT * FROM dbo.ChiTietSP

--Thêm sản phẩm vào chiTietHD(giở hàng)
SELECT * FROM dbo.KhachHang
SELECT * FROM dbo.HoaDon
DELETE FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD
DELETE FROM dbo.ChiTietHD
INSERT INTO ChiTietHD (IdHD, IdChiTietSP) VALUES ('62D99BDC-1D54-461B-A331-45D8F8BB2F2F', '191DD78E-4575-4054-99BC-80C9110B1852')

--Lấy danh sách hóa đơn theo trạng thái 0
SELECT Id, Ma, IdNV, IdKH, NgayTao, NgaySua, NgayThanhToan, TrangThai FROM dbo.HoaDon
WHERE TrangThai = 0
ORDER BY Ma DESC


SELECT * FROM dbo.ChiTietSP ctsp JOIN dbo.SanPham SP
ON SP.Id = ctsp.IdSP JOIN dbo.IMei
ON IMei.IdChiTietSP = ctsp.Id
WHERE  ctsp.Id = '191DD78E-4575-4054-99BC-80C9110B1852'

INSERT INTO ChiTietHD (IdHD, IdChiTietSP, Dongia) VALUES ('62D99BDC-1D54-461B-A331-45D8F8BB2F2F', '4389F990-39FE-4BB2-A6CC-C2671B4571A6', 21000000)

SELECT * FROM dbo.ChiTietHD
DELETE FROM dbo.ChiTietHD WHERE IdChiTietSP = ? AND IdHD = ?
DELETE FROM dbo.HoaDon
DELETE FROM dbo.ChiTietHD

--Lấy danh sách imei theo idChiTietSP
UPDATE dbo.IMei SET TrangThai = 1
SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP
ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP
WHERE IMei.TrangThai = 1 AND IdChiTietSP = '' AND IMei = '100000990945894'

--Lấy idChiTietSP theo imei
SELECT IdChiTietSP FROM dbo.IMei WHERE IMei = '100000990945894'


--Lấy danh sách ImeiDaBan
SELECT IMei, IdChiTietHD, NgayBan, NgayTao, NgaySua, TrangThai FROM dbo.IMeiDaBan
WHERE TrangThai = 0

--Xóa danh sách imeiDaBan
SELECT * FROM dbo.ChiTietHD
INSERT INTO ImeiDaBan (IMei, IdChiTietHD) VALUES ('100001555539570', '21D0A13B-4390-4DD6-A030-BC8EC0637C3B')
DELETE FROM dbo.IMeiDaBan

DELETE FROM dbo.IMeiDaBan WHERE IdChiTietHD = 'E9BD0386-9D17-4330-84D5-844861F5F930'

SELECT Id FROM dbo.ChiTietHD WHERE IdHD = ?

SELECT * FROM dbo.IMeiDaBan

--Thêm bớt số lượng trong chiTietHD
SELECT * FROM dbo.ChiTietHD
UPDATE dbo.ChiTietHD SET SoLuong = SoLuong + 1 WHERE IdHD = '' AND IdChiTietSP = ''
UPDATE dbo.ChiTietHD SET TrangThai = ? WHERE IdHD = ?
SELECT * FROM dbo.HoaDon
DELETE FROM dbo.HoaDon


--update idKH
UPDATE dbo.HoaDon SET IdKH = '' WHERE Id = ''
UPDATE dbo.HoaDon SET TrangThai = '' WHERE Id = ''

--Lấy danh sách imei đã được chọn
SELECT * FROM dbo.ChiTietHD
SELECT * FROM dbo.IMeiDaBan
DELETE FROM dbo.IMeiDaBan

SELECT IMei FROM dbo.IMeiDaBan IMDB JOIN dbo.ChiTietHD CTHD
ON CTHD.Id = IMDB.IdChiTietHD
WHERE IMDB.TrangThai = 0 AND CTHD.Id = '05C9F65C-6EC2-4316-8948-4789D3FB5AD3' AND CTHD.IdChiTietSP = '703284D8-53FC-4405-926A-929CB979D74F'


--Lấy danh sách chi tiết HD & imei đã bán
SELECT DSP.Ten, SP.Ten, MS.Ten, CPU.Ten, RAM.Ten, SSD.Ten, MH.DoPhanGiai, MH.Inch, QuocGia, BH.SoThangBH FROM dbo.ChiTietHD CTHD JOIN dbo.IMeiDaBan IDB
ON IDB.IdChiTietHD = CTHD.Id JOIN dbo.ChiTietSP CTSP
ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.NSX 
ON NSX.Id = CTSP.IdNSX JOIN dbo.CPU 
ON CPU.Id = CTSP.IdCPU JOIN dbo.RAM 
ON RAM.Id = CTSP.IdRAM JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.SSD 
ON SSD.Id = CTSP.IdSSD JOIN dbo.HoaDon HD
ON HD.Id = CTHD.IdHD
WHERE HD.Ma = 'HD83' AND IDB.TrangThai = 0

--update trạng thái khi thanh toán
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD
SELECT * FROM dbo.IMeiDaBan
SELECT * FROM dbo.IMei
SELECT * FROM dbo.ChiTietSP

--update trạng thái imei đã bán
UPDATE dbo.IMeiDaBan SET TrangThai = 1 FROM dbo.ChiTietHD JOIN dbo.IMeiDaBan
ON IMeiDaBan.IdChiTietHD = ChiTietHD.Id
WHERE IdHD = '9CF9C47E-0851-418E-805A-D762FBECD0BB'

UPDATE dbo.IMeiDaBan SET TrangThai = 0
UPDATE dbo.IMei SET TrangThai = 0
UPDATE dbo.HoaDon SET TrangThai = 0, LyDo = 0
UPDATE dbo.ChiTietHD SET TrangThai = 0

UPDATE dbo.ChiTietSP SET SoLuongTon = SoLuongTon - '' WHERE Ma = ?


--update bảng imei
SELECT IMei FROM dbo.IMeiDaBan JOIN dbo.ChiTietHD
ON ChiTietHD.Id = IMeiDaBan.IdChiTietHD JOIN dbo.ChiTietSP CTSP
ON CTSP.Id = ChiTietHD.IdChiTietSP
WHERE IMeiDaBan.TrangThai = 0 AND IdHD = 'F948A6D4-80CB-4908-B610-7BBDD4E63E94'

SELECT * FROM dbo.ChiTietHD
SELECT * FROM dbo.HoaDon
SELECT Ma FROM dbo.ChiTietSP WHERE Id = ''

SELECT * FROM dbo.ChiTietHD 
SELECT * FROM dbo.ChiTietSP
DELETE FROM dbo.HoaDon

UPDATE dbo.HoaDon SET NgayThanhToan = GETDATE(), TrangThai = '' WHERE Id = ''
UPDATE dbo.ChiTietSP SET SoLuongTon = 15 WHERE Ma = 'CTSP2'

SELECT * FROM dbo.KhachHang

UPDATE dbo.HoaDon SET NgayThanhToan = GETDATE(), TrangThai = '', LyDo = '', ThanhTien = '', KhuyenMai = '' WHERE Id = ?

--Lấy danh sách khuyến mãi
SELECT * FROM dbo.KhuyenMai
INSERT INTO KhuyenMai (Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai)
VALUES ('Ma02KM500000', 500000, 10, '2023-07-15', '2023-07-20', 0)
INSERT INTO KhuyenMai (Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai)
VALUES ('Ma03KM200', 200000, 10, '2023-08-01', '2023-08-05', 0)

UPDATE dbo.KhuyenMai SET TrangThai = 2 WHERE Ma = 'Ma02KM500000'

--Lấy danh sách khuyến mãi theo ngayBatDau - ngayKetThuc
SELECT Id, Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai FROM dbo.KhuyenMai
WHERE NgayBatDau <= CURRENT_TIMESTAMP AND NgayKetThuc >= CURRENT_TIMESTAMP

--Lấy danh sách khuyến mãi theo mã và trạng thái
SELECT Id, Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai FROM dbo.KhuyenMai
WHERE TrangThai = 0 AND Ma = ''

UPDATE dbo.KhuyenMai SET SoLuong = '' WHERE Ma = ''
SELECT Id, Ma, IdKH, IdNV, NgayThanhToan, KhuyenMai, ThanhTien, TrangThai, LyDo FROM dbo.HoaDon
WHERE TrangThai = 1 OR TrangThai = 2

SELECT * FROM dbo.KhuyenMai
UPDATE dbo.KhuyenMai SET TrangThai = 1 WHERE Ma = 'Ma03KM200'
 

SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD


SELECT Id, Ma, IdKH, IdNV, NgayThanhToan, KhuyenMai, ThanhTien, TrangThai, LyDo FROM dbo.HoaDon
WHERE NgayThanhToan BETWEEN '2023-07-15' AND '2023-07-26' AND (TrangThai = 1 OR TrangThai = 2)

Select HD.Ma,NV.Ho+' '+ NV.tenDem +' '+ NV.Ten  As 'HoTenNV', KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',HD.NgayThanhToan,HD.TrangThai
From HoaDon HD Join NhanVien NV On HD.idNV = NV.Id
Join KhachHang KH On HD.IdKH = KH.Id
Where HD.TrangThai = '1' OR HD.TrangThai = '2' AND ngaythanhtoan between '2023-05-15' and '2023-05-20'


SELECT * FROM dbo.KhuyenMai
UPDATE dbo.KhuyenMai SET Ma = 'Ma02KM500' WHERE Ma = 'Ma02KM500000'

Select HD.Ma, KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',
HD.NgayThanhToan, HD.TrangThai, KhuyenMai, ThanhTien
From HoaDon HD
Join KhachHang KH On HD.IdKH = KH.Id
Where HD.Ma Like '%HD96%' OR KH.SDT like '%" + tim + "%'

SELECT HD.Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai, LyDo FROM dbo.HoaDon HD JOIN dbo.KhachHang KH
ON KH.Id = HD.IdKH
WHERE HD.Ma LIKE '%HD98%' OR KH.Sdt LIKE '%0999999999%'

SELECT * FROM dbo.KhuyenMai
UPDATE dbo.KhuyenMai SET TrangThai = 0 WHERE Ma ='Ma01KM100'

UPDATE dbo.IMeiDaBan SET NgayBan = GETDATE(), TrangThai = ''

----
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD WHERE IdHD = '6369487F-B685-4549-9AB4-B1F3E67CC7BB'
SELECT * FROM dbo.ChiTietSP
SELECT * FROM dbo.IMei WHERE IdChiTietSP = '4389F990-39FE-4BB2-A6CC-C2671B4571A6'
SELECT * FROM dbo.IMeiDaBan
SELECT * FROM dbo.IMei WHERE IMei LIKE '%%'

UPDATE dbo.ChiTietHD SET ThanhTien = ThanhTien - Dongia 

SELECT * FROM dbo.IMeiDaBan
UPDATE dbo.IMeiDaBan SET IMei = '100000343834124' WHERE IMei = '1'
UPDATE dbo.IMei SET TrangThai = 0 WHERE IMei = '100002036399027'
UPDATE dbo.ChiTietSP SET SoLuongTon = 13 WHERE Ma = 'CTSP2'

SELECT * FROM dbo.HoaDon WHERE Ma = 'HD116'

UPDATE dbo.HoaDon SET TrangThai = 1, LyDo = N'Test lỗi', ThanhTien = ThanhTien, KhuyenMai = KhuyenMai WHERE Id = '720203A6-BB39-4863-956A-6F1AA33AC66F'

SELECT * FROM dbo.IMei WHERE IMei LIKE '%1380%'



SELECT * FROM dbo.ChiTietSP WHERE Id = 'A34E153E-61E6-40A8-A7AC-2C6845D2C5E3'
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.ChiTietHD WHERE IdHD = '021EF05F-2432-488C-A011-FCD574A06E8F'
SELECT * FROM dbo.ChiTietSP WHERE Id = 'A34E153E-61E6-40A8-A7AC-2C6845D2C5E3'
SELECT * FROM dbo.IMeiDaBan WHERE IdChiTietHD = '9E6824C9-DAAC-48D7-AD1D-70EDFD56794D'
SELECT * FROM dbo.IMei

SELECT SoLuong FROM dbo.ChiTietHD WHERE IdHD = '720203A6-BB39-4863-956A-6F1AA33AC66F' AND IdChiTietSP = 'A34E153E-61E6-40A8-A7AC-2C6845D2C5E3'



SELECT CTSP.Id AS 'Id', CTSP.Ma AS 'Ma', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac',
RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.SoThangBH AS 'BaoHanh', CTSP.SoLuongTon AS 'SoLuong', CTSP.TrangThai AS 'TrangThai'
FROM dbo.ChiTietSP CTSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.RAM
ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD
ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU
ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX
ON NSX.Id = CTSP.IdNSX
WHERE CTSP.Id = 'A34E153E-61E6-40A8-A7AC-2C6845D2C5E3'


INSERT INTO ChiTietHD(IdHD, IdChiTietSP, Dongia, ThanhTien, SoLuong, TrangThai) VALUES ()



SELECT Imei,DSP.Ten As 'DSP', SP.Ten AS 'Sp', MS.Ten AS 'MS', CPU.Ten AS 'CPU', RAM.Ten AS'RAM', SSD.Ten AS'SSD',  ConCAT_WS(' ',DoPhanGiai,Inch) +' Inch' AS 'MH', 
QuocGia As 'NSX', BH.SoThangBH AS'BH',CanNang,Mota,GiaBan 
FROM dbo.ChiTietHD CTHD JOIN dbo.IMeiDaBan IDB
ON IDB.IdChiTietHD = CTHD.Id JOIN dbo.ChiTietSP CTSP
ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.DongSP DSP
ON DSP.Id = CTSP.IdDongSP JOIN dbo.SanPham SP
ON SP.Id = CTSP.IdSP JOIN dbo.MauSac MS
ON MS.Id = CTSP.IdMauSac JOIN dbo.NSX
ON NSX.Id = CTSP.IdNSX JOIN dbo.CPU 
ON CPU.Id = CTSP.IdCPU JOIN dbo.RAM 
ON RAM.Id = CTSP.IdRAM JOIN dbo.ManHinh MH
ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH
ON BH.Id = CTSP.IdBH JOIN dbo.SSD
ON SSD.Id = CTSP.IdSSD JOIN dbo.HoaDon HD
ON HD.Id = CTHD.IdHD
WHERE HD.Ma = 'HD119'

SELECT * FROM dbo.ChiTietHD WHERE IdHD = '021EF05F-2432-488C-A011-FCD574A06E8F'

SELECT * FROM dbo.KhuyenMai
ORDER BY NumOrder DESC

UPDATE dbo.ChiTietSP SET SoLuongTon = 5 WHERE Ma = 'CTSP2'



SELECT * FROM ChiTietSP
SELECT * FROM dbo.IMei WHERE IdChiTietSP = '191DD78E-4575-4054-99BC-80C9110B1852'
UPDATE dbo.IMei SET TrangThai = 0 WHERE IdChiTietSP = '191DD78E-4575-4054-99BC-80C9110B1852'



SELECT Sum(ThanhTien) AS 'ThanhTien' from HoaDon
Where NgayThanhToan = GetDate() AND TrangThai = '1'


SELECT Sum(ThanhTien) AS 'ThanhTien' from HoaDon
Where MONTH(NgayThanhToan) = MONTH(GetDate()) AND TrangThai = 1
