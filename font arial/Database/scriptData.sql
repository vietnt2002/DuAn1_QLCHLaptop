USE [master]
GO
/****** Object:  Database [QuanLyCuaHangLaptop]    Script Date: 8/22/2023 7:59:18 PM ******/
CREATE DATABASE [QuanLyCuaHangLaptop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyCuaHangLaptop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyCuaHangLaptop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyCuaHangLaptop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyCuaHangLaptop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyCuaHangLaptop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET QUERY_STORE = OFF
GO
USE [QuanLyCuaHangLaptop]
GO
/****** Object:  Table [dbo].[BaoHanh]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaoHanh](
	[Id] [uniqueidentifier] NOT NULL,
	[SoThangBH] [int] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('BH'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHD]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHD](
	[IdHD] [uniqueidentifier] NOT NULL,
	[Dongia] [decimal](20, 0) NULL,
	[ThanhTien] [decimal](20, 0) NULL,
	[TrangThai] [int] NULL,
	[IdChiTietSP] [uniqueidentifier] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[SoLuong] [int] NULL,
	[Id] [uniqueidentifier] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSP]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdSP] [uniqueidentifier] NULL,
	[IdNSX] [uniqueidentifier] NULL,
	[IdMauSac] [uniqueidentifier] NULL,
	[IdDongSP] [uniqueidentifier] NULL,
	[IdCPU] [uniqueidentifier] NULL,
	[IdRAM] [uniqueidentifier] NULL,
	[IdSSD] [uniqueidentifier] NULL,
	[IdManHinh] [uniqueidentifier] NULL,
	[IdBH] [uniqueidentifier] NULL,
	[CanNang] [decimal](10, 1) NULL,
	[MoTa] [nvarchar](30) NULL,
	[SoLuongTon] [int] NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('CTSP'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('CV'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CPU]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CPU](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('CPU'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DongSP]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DongSP](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('DSP'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [uniqueidentifier] NOT NULL,
	[IdKH] [uniqueidentifier] NULL,
	[IdNV] [uniqueidentifier] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('HD'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
	[NgayThanhToan] [date] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[LyDo] [nvarchar](50) NULL,
	[KhuyenMai] [decimal](20, 0) NULL,
	[ThanhTien] [decimal](20, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IMei]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IMei](
	[Id] [uniqueidentifier] NOT NULL,
	[IMei] [varchar](15) NULL,
	[IdChiTietSP] [uniqueidentifier] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IMeiDaBan]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IMeiDaBan](
	[Id] [uniqueidentifier] NOT NULL,
	[IMei] [varchar](15) NULL,
	[IdChiTietHD] [uniqueidentifier] NULL,
	[NgayBan] [date] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [uniqueidentifier] NOT NULL,
	[NgaySinh] [date] NULL,
	[Sdt] [varchar](10) NULL,
	[DiaChi] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('KH'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [uniqueidentifier] NOT NULL,
	[SoTienGiam] [decimal](20, 0) NULL,
	[SoLuong] [int] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[TrangThai] [int] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('MaKM0'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ManHinh]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ManHinh](
	[Id] [uniqueidentifier] NOT NULL,
	[DoPhanGiai] [varchar](30) NULL,
	[Inch] [float] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('MH'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('MS'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [uniqueidentifier] NOT NULL,
	[IdCV] [uniqueidentifier] NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[NgaySinh] [date] NULL,
	[Sdt] [varchar](10) NULL,
	[DiaChi] [nvarchar](30) NULL,
	[MatKhau] [varchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('NV'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[QuocGia] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('NSX'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RAM]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RAM](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('RAM'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('SP'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SSD]    Script Date: 8/22/2023 7:59:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SSD](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NumOrder] [int] IDENTITY(1,1) NOT NULL,
	[Ma]  AS ('SSD'+CONVERT([varchar](10),[NumOrder])) PERSISTED NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[BaoHanh] ON 

INSERT [dbo].[BaoHanh] ([Id], [SoThangBH], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'59edbe25-fa10-45b2-8498-042e8aa96cf3', 6, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[BaoHanh] ([Id], [SoThangBH], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'fd122e76-f283-4398-b994-2a856c4c89ca', 12, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[BaoHanh] ([Id], [SoThangBH], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'1bc73db4-7c7c-4336-9200-ff7c05c7396f', 24, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
SET IDENTITY_INSERT [dbo].[BaoHanh] OFF
GO
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'1d4e7ac4-7411-44f0-a3d9-24cb38a2d440', CAST(23500000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), 1, N'fc88aa8f-f62c-4a1c-9e13-014885b0c2dc')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'328152bf-b404-4474-b1e7-bb79bc736364', CAST(21000000 AS Decimal(20, 0)), CAST(42000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 2, N'2d1b73de-6ef7-47d9-8aac-0b2faee368ac')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'e72813ed-8e00-4809-aa32-1b370677050e', CAST(23500000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1, N'7f45891e-03b2-4961-98ee-1014121b0e57')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'1d99f771-8842-471b-8f5d-73adc83d6720', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'447f42b1-1553-4f5c-b1d9-13e496278e96')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'89db0534-eb99-4b14-856b-ab9391a18822', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'384dd6e6-bad9-4dcc-a1c2-1578de7b1b0c')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'0e13892e-55c2-4964-af3e-c8994fda2600', CAST(23500000 AS Decimal(20, 0)), CAST(47000000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 2, N'dcb21250-8516-436f-9475-17a94261864c')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'fd96192f-9448-486b-b7cf-bf0715a7a116', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1, N'd2176fa6-2eaa-4bf2-bd11-19ea5dcf9684')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'5e5f912c-87c2-4929-acfc-d1e8cd1ef67e', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-22' AS Date), 1, N'eabe8870-fc7e-4820-a995-216c5a57e05f')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'898c3d5a-91f3-4a1a-8779-7063b9eda216', CAST(34000000 AS Decimal(20, 0)), CAST(34000000 AS Decimal(20, 0)), 1, N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), 1, N'a6e1003f-c5a0-437d-a559-293302220bc7')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd37ed21e-a800-42a0-92ea-6773586dc445', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'797e61c6-2305-4318-80fe-2e6dd3227deb')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'c0930058-fbc7-4253-b71a-58db7e65525c', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), 1, N'12476540-79c4-4f67-b128-3cae23c5121d')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'69404fb4-ec00-4678-95b0-12c75c276ce7', CAST(23500000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), 2, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 0, N'c6f46efd-3a89-47c0-841d-41f32029f597')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'8daa37f3-4ea9-4254-a945-3edc3387e2f5', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'f5bba9eb-4509-4806-a88b-4268f0d0ce08')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'c936485d-1ead-4d43-ab95-fd683aaa5d73', CAST(23500000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1, N'b835a836-8289-48a4-a446-4320405135f4')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'7ea9ca83-6bdc-4b58-8290-830114427ff8', CAST(23000000 AS Decimal(20, 0)), CAST(46000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1, N'2809ec48-1fcd-45d3-bd0d-507db5b67228')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'8805d3a6-c0f2-457a-beda-61e87274f3b7', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 2, N'b278a28f-b708-463c-95bc-51219b51b10c')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'02143d92-2977-4752-90ef-67999fe9080b', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1, N'be9509ea-33f5-41ad-9841-537c46427750')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'e7db6cb3-973a-4c94-b3b6-fd8b5ba39e46', CAST(32500000 AS Decimal(20, 0)), CAST(32500000 AS Decimal(20, 0)), 1, N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1, N'28f9610d-8ecf-435f-898d-55a1044f2237')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'27bb5d87-0542-4fa6-8888-1873cd7daf7b', CAST(23000000 AS Decimal(20, 0)), CAST(46000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 2, N'1ab4dae5-fa56-44f3-a5e3-598d54c542bd')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'18f08687-1d03-43c4-b4bc-8011cd2d5497', CAST(23500000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-22' AS Date), 1, N'4c1a03ae-11a5-4d42-a27f-61b2b4b35072')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'5f451b15-9d9e-4ca5-8d61-3c4d7b150c37', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), 1, N'4f9bd833-18b4-4d67-bc93-67b3f9c17ac0')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'5f451b15-9d9e-4ca5-8d61-3c4d7b150c37', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'486b2ea6-946a-43a5-b220-6f04954479ca')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'147be274-6346-4860-9b46-57c9fa55d0da', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'73200287-24e7-4a7f-80c4-6fdef09a7964')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'021ef05f-2432-488c-a011-fcd574a06e8f', CAST(23500000 AS Decimal(20, 0)), CAST(47000000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), 1, N'e03ff2af-e886-4a78-95f7-7020a23c201e')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'021ef05f-2432-488c-a011-fcd574a06e8f', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), 1, N'9e6824c9-daac-48d7-ad1d-70edfd56794d')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'27bb5d87-0542-4fa6-8888-1873cd7daf7b', CAST(23500000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), 1, N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'6f1a6b0e-7cf4-4c10-bffc-7ae3185bcde9')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'03d44e85-13f0-4cf0-9c8b-8c415896eea8', CAST(34000000 AS Decimal(20, 0)), CAST(34000000 AS Decimal(20, 0)), 1, N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1, N'fcee0df2-a1bf-4c6a-8986-7ff1860343da')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'f7d1c440-c86c-4b11-911d-98e95071d426', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'3908e708-6c00-4c8d-85a1-8ea13a9f31f7')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd37ed21e-a800-42a0-92ea-6773586dc445', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'165a92b5-1d08-4152-9325-92d97ff85999')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'8805d3a6-c0f2-457a-beda-61e87274f3b7', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1, N'a3d2e90c-1809-4b88-ae3f-933d8156f371')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'720203a6-bb39-4863-956a-6f1aa33ac66f', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-08-08' AS Date), 1, N'899edf4e-6096-4317-b1c2-97632b162ce3')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'99967017-3f49-499b-8bb0-e5c5ac772010', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1, N'43b4ae4a-11ea-4769-814b-a146ce2a0632')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'68bebcca-dcdd-43ac-993a-2c721c030d3f', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 1, N'deea29ee-3547-4222-b937-a34c9db3d13c')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'cfeb58eb-bdaa-48de-894a-de447f992c92', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-21' AS Date), 1, N'73e6223e-ab01-46cd-b74d-a41d279449b8')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'e72813ed-8e00-4809-aa32-1b370677050e', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1, N'be8697b0-735f-4858-bd6d-ad4d5f1ec9b2')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'2d7fc9ac-951a-4bed-9714-b85ae6441464', CAST(34000000 AS Decimal(20, 0)), CAST(34000000 AS Decimal(20, 0)), 1, N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 1, N'eff97e1b-4f25-4cc6-adf3-adae9ddb9001')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'6369487f-b685-4549-9ab4-b1f3e67cc7bb', CAST(25000000 AS Decimal(20, 0)), CAST(50000000 AS Decimal(20, 0)), 1, N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), 2, N'1cdc75bf-7ade-41ee-a6e1-b0dd2f828b3a')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'e9e0a312-39cf-40c2-8a76-d5944d4fc239', CAST(32500000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), 2, N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 0, N'4d2d53c7-49a9-4986-a5df-b3d71f3da2ec')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'0e13892e-55c2-4964-af3e-c8994fda2600', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1, N'048f1439-9cb6-480d-b00e-bcab305961ba')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd5a8ccf8-1317-49ad-ad7e-ade785221c42', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'2049ee50-c330-4260-89d0-be205468020f')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'20f82ff7-5257-425a-9d11-82225a05c90f', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1, N'65139f50-e0ff-4c81-b130-be4fd0c8df9c')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'328152bf-b404-4474-b1e7-bb79bc736364', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'69b8afc1-3505-485e-9ec1-c255d2ab5383')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'f86bfadf-ebac-4f0d-8e9b-e2c379c86994', CAST(32500000 AS Decimal(20, 0)), CAST(130000000 AS Decimal(20, 0)), 1, N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 4, N'3de67ed2-fad1-4175-8130-da339de147e9')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'1b09f522-5603-470a-b329-140742c244cc', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), 1, N'04e05c8a-4488-4e70-a980-dc40712d1ffb')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'99967017-3f49-499b-8bb0-e5c5ac772010', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-10' AS Date), CAST(N'2023-08-10' AS Date), 1, N'125a95ad-0194-476d-b340-e1f06300bf40')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'68a40950-a639-4892-89ef-a6f002dc622f', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-30' AS Date), CAST(N'2023-07-30' AS Date), 1, N'221b1050-2cf2-4a20-82c7-e38697cc473b')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd5a8ccf8-1317-49ad-ad7e-ade785221c42', CAST(21000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'426e7ebf-0d46-411c-ab8c-e4bac89c2267')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd5a8ccf8-1317-49ad-ad7e-ade785221c42', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'682ff9f2-0bbc-4c94-8485-efc275de7747')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'8daa37f3-4ea9-4254-a945-3edc3387e2f5', CAST(21000000 AS Decimal(20, 0)), CAST(42000000 AS Decimal(20, 0)), 1, N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 2, N'20057dfc-0fdc-4f37-8c2c-f460c4be07d9')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'd37ed21e-a800-42a0-92ea-6773586dc445', CAST(25000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), 1, N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1, N'472d30fe-493c-4984-9acb-f864d3d75c85')
INSERT [dbo].[ChiTietHD] ([IdHD], [Dongia], [ThanhTien], [TrangThai], [IdChiTietSP], [NgayTao], [NgaySua], [SoLuong], [Id]) VALUES (N'e72813ed-8e00-4809-aa32-1b370677050e', CAST(23000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), 1, N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1, N'59e5b843-2394-431c-ae10-fcb9990929c6')
GO
SET IDENTITY_INSERT [dbo].[ChiTietSP] ON 

INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', N'5d8cc3e7-2904-4324-a035-6f3b5c07a78f', N'52eb796e-5d45-41ab-b8b9-e8b805cc56ea', N'8f6ea32c-4f94-4fdb-bd11-d4743941f8aa', N'b573ed10-57da-4d84-9cc8-1654a0860109', N'eec447fd-5706-4d07-875e-66c931b2fffc', N'c3f04112-627d-432a-b8de-1777b40c5fb9', N'f0d85033-738c-474f-a9e5-14d93f83ec0d', N'c0a6c5de-61d2-47b9-a31e-484c05adec42', N'59edbe25-fa10-45b2-8498-042e8aa96cf3', CAST(1.6 AS Decimal(10, 1)), N'Phù hợp với sinh viên', 0, CAST(19000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-31' AS Date), 0, 1)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', N'65b3751c-7b5d-4cd5-8c89-5ff0270963f4', N'dc6ad5fb-764d-4e72-ae97-62445d361364', N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'403b4ffc-5dd7-448a-baca-2c2489c7c684', N'3fe0cddd-acb7-41f6-824c-2fa0aa73bf0b', N'80da6c0a-02d9-48fe-87e8-221c4a2e37a8', N'f0d85033-738c-474f-a9e5-14d93f83ec0d', N'd7fd200f-1e97-43b5-ac9e-855d9fe5e212', N'fd122e76-f283-4398-b994-2a856c4c89ca', CAST(2.2 AS Decimal(10, 1)), N'Phù hợp với game thủ', 3, CAST(21000000 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 2)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'191dd78e-4575-4054-99bc-80c9110b1852', N'08e3cbb3-60e9-48e4-ae13-cc048457d0f1', N'd9a54e5a-d8f5-4803-8ba0-3a4b787875ef', N'51a60013-2a9c-46af-9914-b75f4c1e771f', N'e063c9bc-5611-4df0-813e-45905a3c4560', N'3dd1bcd3-1b8b-4011-8620-998602b39da2', N'80da6c0a-02d9-48fe-87e8-221c4a2e37a8', N'f0d85033-738c-474f-a9e5-14d93f83ec0d', N'83d51f04-3998-41f4-bf34-a779c87ed09e', N'fd122e76-f283-4398-b994-2a856c4c89ca', CAST(1.8 AS Decimal(10, 1)), N'Phù hợp với dân văn phòng', 5, CAST(24000000 AS Decimal(20, 0)), CAST(27000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 3)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'c1126369-56e3-491a-b622-871746b5b188', N'65b3751c-7b5d-4cd5-8c89-5ff0270963f4', N'dc6ad5fb-764d-4e72-ae97-62445d361364', N'51a60013-2a9c-46af-9914-b75f4c1e771f', N'403b4ffc-5dd7-448a-baca-2c2489c7c684', N'069618d0-34b8-488c-a69f-444071f8ab00', N'bff9b107-008a-4dd3-9d94-f66da52c24db', N'b3d62084-9cfe-4dc4-bcc5-dfca9467e3df', N'83d51f04-3998-41f4-bf34-a779c87ed09e', N'59edbe25-fa10-45b2-8498-042e8aa96cf3', CAST(2.0 AS Decimal(10, 1)), N'Phù hợp với game thủ', 8, CAST(23000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 4)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'703284d8-53fc-4405-926a-929cb979d74f', N'10a76c58-bd7d-4059-a314-e6efb3b22346', N'76f4f906-2dd9-4724-97c5-126d94f2de01', N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'886684c2-3cb1-4ef5-bc96-c2c85175e5c7', N'3fe0cddd-acb7-41f6-824c-2fa0aa73bf0b', N'c3f04112-627d-432a-b8de-1777b40c5fb9', N'f0d85033-738c-474f-a9e5-14d93f83ec0d', N'd7fd200f-1e97-43b5-ac9e-855d9fe5e212', N'1bc73db4-7c7c-4336-9200-ff7c05c7396f', CAST(1.6 AS Decimal(10, 1)), N'Phù hợp với việc văn phòng', 9, CAST(31000000 AS Decimal(20, 0)), CAST(34000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 5)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', N'5d8cc3e7-2904-4324-a035-6f3b5c07a78f', N'52eb796e-5d45-41ab-b8b9-e8b805cc56ea', N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'b573ed10-57da-4d84-9cc8-1654a0860109', N'eec447fd-5706-4d07-875e-66c931b2fffc', N'bff9b107-008a-4dd3-9d94-f66da52c24db', N'16a0cdf4-bb82-42b8-96fc-cab1bb2bd9c2', N'c0a6c5de-61d2-47b9-a31e-484c05adec42', N'59edbe25-fa10-45b2-8498-042e8aa96cf3', CAST(1.6 AS Decimal(10, 1)), N'Phù hợp với sinh viên', 9, CAST(20000000 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 6)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', N'10a76c58-bd7d-4059-a314-e6efb3b22346', N'76f4f906-2dd9-4724-97c5-126d94f2de01', N'8f6ea32c-4f94-4fdb-bd11-d4743941f8aa', N'886684c2-3cb1-4ef5-bc96-c2c85175e5c7', N'eec447fd-5706-4d07-875e-66c931b2fffc', N'666af59c-db60-4176-b84a-aaf4bc8f126f', N'16a0cdf4-bb82-42b8-96fc-cab1bb2bd9c2', N'8710bb21-397f-4705-bb51-e25e20390c4b', N'1bc73db4-7c7c-4336-9200-ff7c05c7396f', CAST(1.6 AS Decimal(10, 1)), N'Phù hợp với việc văn phòng', 0, CAST(28000000 AS Decimal(20, 0)), CAST(32500000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-28' AS Date), 0, 7)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'40afdad3-06d4-459c-b70e-dfaf58e109c0', N'279964ab-2975-43a2-bf8c-9bde2d64ff37', N'ac4aa0fb-2745-4da9-9011-3f10a5b6e978', N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'36b492bc-600a-4e70-bb43-1f01cf6f7aa4', N'069618d0-34b8-488c-a69f-444071f8ab00', N'666af59c-db60-4176-b84a-aaf4bc8f126f', N'16a0cdf4-bb82-42b8-96fc-cab1bb2bd9c2', N'c0a6c5de-61d2-47b9-a31e-484c05adec42', N'fd122e76-f283-4398-b994-2a856c4c89ca', CAST(1.8 AS Decimal(10, 1)), N'Phù hợp với sinh viên', 7, CAST(19000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 8)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'7314834c-0ab8-4bbb-b193-f3afee66eb98', N'08e3cbb3-60e9-48e4-ae13-cc048457d0f1', N'd9a54e5a-d8f5-4803-8ba0-3a4b787875ef', N'51a60013-2a9c-46af-9914-b75f4c1e771f', N'e063c9bc-5611-4df0-813e-45905a3c4560', N'3dd1bcd3-1b8b-4011-8620-998602b39da2', N'bff9b107-008a-4dd3-9d94-f66da52c24db', N'b3d62084-9cfe-4dc4-bcc5-dfca9467e3df', N'83d51f04-3998-41f4-bf34-a779c87ed09e', N'fd122e76-f283-4398-b994-2a856c4c89ca', CAST(1.8 AS Decimal(10, 1)), N'Phù hợp với dân văn phòng', 4, CAST(22000000 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 9)
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNSX], [IdMauSac], [IdDongSP], [IdCPU], [IdRAM], [IdSSD], [IdManHinh], [IdBH], [CanNang], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [NgayTao], [NgaySua], [TrangThai], [NumOrder]) VALUES (N'd7063ab4-c49b-449d-ac40-fb815806b2b0', N'279964ab-2975-43a2-bf8c-9bde2d64ff37', N'ac4aa0fb-2745-4da9-9011-3f10a5b6e978', N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'36b492bc-600a-4e70-bb43-1f01cf6f7aa4', N'069618d0-34b8-488c-a69f-444071f8ab00', N'bff9b107-008a-4dd3-9d94-f66da52c24db', N'16a0cdf4-bb82-42b8-96fc-cab1bb2bd9c2', N'83d51f04-3998-41f4-bf34-a779c87ed09e', N'fd122e76-f283-4398-b994-2a856c4c89ca', CAST(1.8 AS Decimal(10, 1)), N'Phù hợp với sinh viên', 2, CAST(18000000 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)), CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 10)
SET IDENTITY_INSERT [dbo].[ChiTietSP] OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'5f2629e3-d4b9-403b-a132-62c4377feffd', N'Quản lý', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[ChucVu] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'28e1793d-2b2e-4377-8327-b27c8b26752f', N'Nhân viên', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[CPU] ON 

INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'2d96d549-68a8-4156-b75f-2923d2e4f85e', N'CPU Intel Core i5', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'3fe0cddd-acb7-41f6-824c-2fa0aa73bf0b', N'CPU Intel Core i7', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'069618d0-34b8-488c-a69f-444071f8ab00', N'CPU ADM Ryzen Threadripper', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 6, 0)
INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'eec447fd-5706-4d07-875e-66c931b2fffc', N'CPU ADM Ryzen 5', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'3dd1bcd3-1b8b-4011-8620-998602b39da2', N'CPU Intel Core i9', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[CPU] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'8d53861d-9f36-434c-bdde-cc130346a355', N'CPU ADM Ryzen 7', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
SET IDENTITY_INSERT [dbo].[CPU] OFF
GO
SET IDENTITY_INSERT [dbo].[DongSP] ON 

INSERT [dbo].[DongSP] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'b573ed10-57da-4d84-9cc8-1654a0860109', N'Dell', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[DongSP] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'36b492bc-600a-4e70-bb43-1f01cf6f7aa4', N'MSI', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
INSERT [dbo].[DongSP] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'403b4ffc-5dd7-448a-baca-2c2489c7c684', N'Acer', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
INSERT [dbo].[DongSP] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'e063c9bc-5611-4df0-813e-45905a3c4560', N'HP', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[DongSP] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'886684c2-3cb1-4ef5-bc96-c2c85175e5c7', N'MacBook', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
SET IDENTITY_INSERT [dbo].[DongSP] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'69404fb4-ec00-4678-95b0-12c75c276ce7', NULL, N'a323127f-4e8d-4abe-b223-90f4f948ce36', 107, 2, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), N'Khách hàng không muốn mua nữa', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'1b09f522-5603-470a-b329-140742c244cc', N'011f4656-b891-4583-badd-e67edf892eae', N'd618597a-f5b3-4250-8fec-ded826b99377', 135, 1, CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'27bb5d87-0542-4fa6-8888-1873cd7daf7b', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 121, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(69500000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'e72813ed-8e00-4809-aa32-1b370677050e', N'011f4656-b891-4583-badd-e67edf892eae', N'd618597a-f5b3-4250-8fec-ded826b99377', 120, 1, CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), N'Bán nhầm sản phẩm. Đồng ý đổi hàng', CAST(0 AS Decimal(20, 0)), CAST(69500000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'1d4e7ac4-7411-44f0-a3d9-24cb38a2d440', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'd618597a-f5b3-4250-8fec-ded826b99377', 136, 1, CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'68bebcca-dcdd-43ac-993a-2c721c030d3f', N'011f4656-b891-4583-badd-e67edf892eae', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 95, 1, CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'5f451b15-9d9e-4ca5-8d61-3c4d7b150c37', N'011f4656-b891-4583-badd-e67edf892eae', N'd618597a-f5b3-4250-8fec-ded826b99377', 128, 1, CAST(N'2023-08-21' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'Bán nhầm hàng', CAST(0 AS Decimal(20, 0)), CAST(44000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'8daa37f3-4ea9-4254-a945-3edc3387e2f5', N'0dda8fde-f563-4da2-ab66-84af109c5e94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 122, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(67000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'da72e631-be71-468f-bc22-461a087ae79b', NULL, N'a323127f-4e8d-4abe-b223-90f4f948ce36', 111, 2, CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'K MUA', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'147be274-6346-4860-9b46-57c9fa55d0da', N'0dda8fde-f563-4da2-ab66-84af109c5e94', N'd618597a-f5b3-4250-8fec-ded826b99377', 123, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'c0930058-fbc7-4253-b71a-58db7e65525c', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 109, 1, CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'8805d3a6-c0f2-457a-beda-61e87274f3b7', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 117, 1, CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), N'Bán nhầm', CAST(0 AS Decimal(20, 0)), CAST(75000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'0e7c4278-be36-4165-92e4-6468af77f1f2', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 113, 2, CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'K MUA', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'd37ed21e-a800-42a0-92ea-6773586dc445', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'd618597a-f5b3-4250-8fec-ded826b99377', 129, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'Giao nhầm hàng: Đồng ý đổi hàng', CAST(0 AS Decimal(20, 0)), CAST(67000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'02143d92-2977-4752-90ef-67999fe9080b', N'011f4656-b891-4583-badd-e67edf892eae', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 102, 1, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'720203a6-bb39-4863-956a-6f1aa33ac66f', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 116, 1, CAST(N'2023-08-08' AS Date), CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), N'Bán nhầm hàng', CAST(0 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'898c3d5a-91f3-4a1a-8779-7063b9eda216', N'011f4656-b891-4583-badd-e67edf892eae', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 98, 1, CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), N'0', CAST(100000 AS Decimal(20, 0)), CAST(33900000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'1d99f771-8842-471b-8f5d-73adc83d6720', N'011f4656-b891-4583-badd-e67edf892eae', N'd618597a-f5b3-4250-8fec-ded826b99377', 127, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'18f08687-1d03-43c4-b4bc-8011cd2d5497', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'd618597a-f5b3-4250-8fec-ded826b99377', 133, 1, CAST(N'2023-08-22' AS Date), CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), N'0', CAST(1000000 AS Decimal(20, 0)), CAST(22500000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'20f82ff7-5257-425a-9d11-82225a05c90f', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 105, 1, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'7ea9ca83-6bdc-4b58-8290-830114427ff8', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 118, 1, CAST(N'2023-08-09' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), N'test', CAST(300000 AS Decimal(20, 0)), CAST(46200000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'03d44e85-13f0-4cf0-9c8b-8c415896eea8', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 106, 1, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), N'0', CAST(100000 AS Decimal(20, 0)), CAST(33900000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'be28240e-cfee-40b2-977b-901a13d7c8d7', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 110, 2, CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'K MUA', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'f7d1c440-c86c-4b11-911d-98e95071d426', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'd618597a-f5b3-4250-8fec-ded826b99377', 126, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'68a40950-a639-4892-89ef-a6f002dc622f', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 114, 1, CAST(N'2023-08-03' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'Đổi hàng', CAST(0 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'89db0534-eb99-4b14-856b-ab9391a18822', N'0dda8fde-f563-4da2-ab66-84af109c5e94', N'd618597a-f5b3-4250-8fec-ded826b99377', 125, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'd5a8ccf8-1317-49ad-ad7e-ade785221c42', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'd618597a-f5b3-4250-8fec-ded826b99377', 130, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'Bán nhầm hàng: Đồng ý đổi hàng', CAST(0 AS Decimal(20, 0)), CAST(67000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'558ddc4b-426b-46b8-ac8e-ae593f389218', N'011f4656-b891-4583-badd-e67edf892eae', N'd618597a-f5b3-4250-8fec-ded826b99377', 134, 2, CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), N'Khách ko mua', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'6369487f-b685-4549-9ab4-b1f3e67cc7bb', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 108, 1, CAST(N'2023-07-31' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'Trả 1 sản phẩm: vì mua nhiều ko dùng đến', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'2d7fc9ac-951a-4bed-9714-b85ae6441464', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 96, 1, CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(34000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'328152bf-b404-4474-b1e7-bb79bc736364', N'b9e9281a-9ab1-459c-972e-5d39b3d3dac2', N'd618597a-f5b3-4250-8fec-ded826b99377', 131, 1, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'Lỗi do nhà sản xuất: Đồng ý đổi hàng', CAST(100000 AS Decimal(20, 0)), CAST(66900000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'fd96192f-9448-486b-b7cf-bf0715a7a116', N'b9e9281a-9ab1-459c-972e-5d39b3d3dac2', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 101, 1, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(25000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'0e13892e-55c2-4964-af3e-c8994fda2600', N'011f4656-b891-4583-badd-e67edf892eae', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 115, 1, CAST(N'2023-08-03' AS Date), CAST(N'2023-07-30' AS Date), CAST(N'2023-07-30' AS Date), N'Lỗi nhà sản xuất. Đồng ý đổi hàng', CAST(0 AS Decimal(20, 0)), CAST(23000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'8cc99967-0081-4f43-bdeb-cabe14b84040', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 112, 2, CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), N'K MUA', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'5e5f912c-87c2-4929-acfc-d1e8cd1ef67e', N'b9e9281a-9ab1-459c-972e-5d39b3d3dac2', N'd618597a-f5b3-4250-8fec-ded826b99377', 132, 1, CAST(N'2023-08-22' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(1000000 AS Decimal(20, 0)), CAST(22000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'e9e0a312-39cf-40c2-8a76-d5944d4fc239', N'31849c7d-203d-4add-ac6b-48a87202e10b', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 94, 2, CAST(N'2023-07-25' AS Date), CAST(N'2023-07-24' AS Date), CAST(N'2023-07-24' AS Date), N'Khách hàng không muốn mua nữa', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'cfeb58eb-bdaa-48de-894a-de447f992c92', N'0dda8fde-f563-4da2-ab66-84af109c5e94', N'd618597a-f5b3-4250-8fec-ded826b99377', 124, 1, CAST(N'2023-08-21' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(21000000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'f86bfadf-ebac-4f0d-8e9b-e2c379c86994', N'011f4656-b891-4583-badd-e67edf892eae', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 100, 1, CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), N'0', CAST(100000 AS Decimal(20, 0)), CAST(129900000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'99967017-3f49-499b-8bb0-e5c5ac772010', N'b9e9281a-9ab1-459c-972e-5d39b3d3dac2', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 103, 1, CAST(N'2023-08-10' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), N'0', CAST(100000 AS Decimal(20, 0)), CAST(45900000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'2051f0ce-3c2d-4bb3-9193-ee8a2ac04107', NULL, N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 97, 2, CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), N'Không muốn mua', CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'021ef05f-2432-488c-a011-fcd574a06e8f', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 119, 1, CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), N'Bán nhầm', CAST(300000 AS Decimal(20, 0)), CAST(46200000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'c936485d-1ead-4d43-ab95-fd683aaa5d73', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'a323127f-4e8d-4abe-b223-90f4f948ce36', 104, 1, CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), N'0', CAST(0 AS Decimal(20, 0)), CAST(23500000 AS Decimal(20, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [NumOrder], [TrangThai], [NgayThanhToan], [NgayTao], [NgaySua], [LyDo], [KhuyenMai], [ThanhTien]) VALUES (N'e7db6cb3-973a-4c94-b3b6-fd8b5ba39e46', N'625eedaa-df43-4441-b60d-51cfa5293b94', N'e7753662-4f8d-4627-8b5b-a36541d88cc8', 99, 1, CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), N'0', CAST(100000 AS Decimal(20, 0)), CAST(32400000 AS Decimal(20, 0)))
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8be09273-ee2c-4915-a8fb-01088732683f', N'100002047334329', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'55e9fe6c-fd66-49a7-bf2d-04f84a10987f', N'100001363426963', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-30' AS Date), CAST(N'2023-07-30' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'bd67e75d-c288-44c2-9fba-06667c779472', N'100000990945894', N'191dd78e-4575-4054-99bc-80c9110b1852', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'00872872-9a8c-4c71-b4e6-070bb39f261f', N'100000447507625', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'fe49b634-be41-4b9d-8b01-10d5dae857e6', N'100002036399027', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3727d6a0-06f3-448e-a751-1318ff3b6604', N'100000346514384', N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'aac52ea3-3ab4-4cf5-81c2-156f63c03067', N'100000212597840', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'01f2215d-42b5-44ab-88bc-1965ed84451c', N'100001985391380', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'eb7bd4d9-8d0f-48e1-a4b9-1e4bc33723ea', N'100001863380218', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'9c77aadf-4cb5-413e-a1d9-1e91c15bf570', N'100002087379775', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'4ffec53e-afa7-4a73-b95f-1fa1e410abf6', N'100002122623332', N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e5c880dc-f46a-4af3-a3a5-2022d47f471a', N'100001615367327', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'c0a41212-1a64-4b72-99c4-212d2099c210', N'100000535785531', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'9b420b0a-b1d3-4ae6-a649-229da353aadc', N'100000627657828', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8f8f28c2-5a57-48d7-a46f-258eaeca5ba3', N'100001165819030', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'be81bc30-4814-406a-a010-2978bfba3dcd', N'100000431478040', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e09bc27d-987d-48fd-9db0-29d181531e61', N'100000177414863', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'bc0773b0-2c51-4c0e-bcb5-2d83bf4af56c', N'100000027189329', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e07c0009-cb16-4b6c-ab52-2dc19be582d9', N'100001883904066', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'eb66ef39-fbed-4899-a1b6-2e6a5af77183', N'100000673922209', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'38d66f50-0f1d-4132-aff8-30d1ec26759c', N'100002043631089', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'cea902ea-e4af-4b0e-b310-333b28c03c1b', N'100000273926939', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7333b189-ccb1-4be3-acb9-3a5fe38f3072', N'100001457944392', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'6d9ff119-c782-4066-be56-3e664fb11277', N'100002054263383', N'191dd78e-4575-4054-99bc-80c9110b1852', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7ee2ff9e-28c3-4c69-b7c5-44a30161f924', N'100001159833501', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'c1193ada-b8dd-4543-a774-4675fed191af', N'100002023643148', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0a755316-c07b-4612-98f3-48b6ce767519', N'100001359799775', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'21285847-32b5-4fcc-88de-515ae51d7651', N'100001187352359', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ad624051-1822-4050-a0f3-51fc37f2c6c9', N'100001746984592', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'080e9b39-82ea-4aff-9420-56a7d1b7f51b', N'100001847007248', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'bd395680-f7a9-482b-8df0-57b8cfd81e62', N'100001235284501', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'360b9e40-1c41-4fec-8037-58e2ab9c97e8', N'100001414496018', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'71475215-41fc-4cfa-ac4f-5a95e49216b6', N'100002048928034', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'42217696-0bde-49b1-a4ff-5b9206e7baec', N'100000154639941', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'281c7fac-8d25-468d-87a1-60a2ca9fc419', N'100001362025865', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'02e59719-301e-40a9-a993-613eeca340b9', N'100001328497797', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5963ad7c-28e1-4d00-b684-64f341695099', N'100001975757892', N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ffee7563-b56b-4ac6-8ecc-6560c1277b2b', N'100000102061851', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a6eea03f-cbc2-4854-96f3-67eb2be633e7', N'100000165876020', N'191dd78e-4575-4054-99bc-80c9110b1852', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7b854a86-93c3-4684-8b5a-6c0182fda14b', N'100000619065473', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'35075fd9-fe85-4299-b841-6fd3e5d90f49', N'100000113384548', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'89019c8e-9a60-4420-a5c2-7073f6912820', N'100000098661241', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7c7e54b8-d504-4d06-bbf2-70dca9cffa5f', N'100000690505709', N'191dd78e-4575-4054-99bc-80c9110b1852', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'32c59153-90c8-4e2c-91ec-71969e16e430', N'100000544711494', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'd12efdfe-fd03-4ee6-92e5-72a3eece7ad0', N'100002019422314', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'18ea7e17-32a0-4fb4-8f3c-73c2318f87d0', N'100001970964338', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'40a7c1a5-cafa-4fc4-a01c-74a2f3c46b76', N'100000747443914', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'fc000998-7490-4531-b793-7612baa9ebf1', N'100001714360110', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'15bee905-cb1c-432b-8529-761e38d88403', N'100001102350104', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'51c20818-00b6-47f4-b50d-763f6bad6bb9', N'100000634694458', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'03bf1919-1e40-42ea-a3c0-76bd769df582', N'100000861078224', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ad516476-96ba-465e-891b-77514e2a9b2a', N'100001207968267', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ca892311-e58c-41b7-baf4-789b11f5c0a4', N'100001003222220', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'f131990d-c2ce-498c-be18-796bfdea85a8', N'100000487798601', N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'fe2b9ec0-2bf7-4d72-98b0-7f5825ce67d5', N'100000343834124', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'36b1790a-0ca3-4e53-841f-80b1bbbb3a22', N'100001296072912', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'28721faf-c7ce-4b8b-95bb-8115584572b8', N'100001673959697', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3a77b82c-53c9-479e-bc0a-8525b3f3c235', N'100001164955181', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7c14ea04-2e29-4bbb-8404-85b1812ea503', N'100000252135146', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3d4f9c42-b195-4a1e-968a-874832b42bce', N'100002080779868', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ccff9798-8951-4e31-bcb2-8bbdfcd738d3', N'100002064458500', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8497aad1-339f-4c1b-8a14-8dd356a476b7', N'100000612571780', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'f0d84e84-f9f3-4452-adab-8ef78b1b02ea', N'100000292469864', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'304c4596-3fa4-4516-adac-912ca5e5ac6e', N'100001048942365', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'f54c6fe2-bbfb-44fc-9fc6-918254122584', N'100000189348157', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'68a47798-4799-443a-9659-95d84f98af5c', N'100001555539570', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0c28d57e-5149-46d1-a4e4-9caa30adad5b', N'100000679512548', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'd81acbaa-bfdc-4177-8e87-9f01f724eefd', N'100000179270391', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'cea6072a-4b5b-47b9-969f-9f6e1d094272', N'100001110738926', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0d362135-17f3-4510-9e85-a0e1ed8ebd32', N'100001082266537', N'4389f990-39fe-4bb2-a6cc-c2671b4571a6', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8f8c9b40-7cc4-4430-abc1-a6608a576339', N'100000394534599', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8f7412d3-9f25-4982-8e33-aa37284d8132', N'100001707357048', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3d44e09a-0dc7-47e8-a5f1-b087a9e52984', N'100001437348285', N'191dd78e-4575-4054-99bc-80c9110b1852', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'98456a66-0092-4b36-a097-b5b6946170ff', N'100000389702409', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5dc7261b-8990-47c1-bad1-b84680d2b5f2', N'100000938019928', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3ef3c789-dd87-41fa-bbf0-baa7f07006e1', N'100001460682781', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'fc583793-d87a-4566-9390-c02fdd628730', N'100001613179186', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'04ba859a-a062-4f23-ad28-c1cae93ee48d', N'100000213182169', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'39351d39-157b-4436-a928-c3f8d381f2f4', N'100001735496451', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'72b9f101-b2ce-4e0b-8d04-c819f7390595', N'100000099326675', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0f9da881-6be5-412a-be14-c8e737972593', N'100000812556472', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5b1e7b40-805f-44f8-9054-cce7fcaf7865', N'100000920853673', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e57b3a5e-d474-4bba-8bad-cd16b3aa604e', N'100001022259671', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'2026509b-42db-4627-ab71-cd366279faf1', N'100000978953118', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'71f137d4-d403-4a71-ad5a-cfdfa171cde5', N'100002040871866', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5358eb70-6837-4db2-968a-d0c60eb843f8', N'100001936876526', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'345c3f83-6457-4cd4-bafa-d0e20d5cfdb4', N'100001066204732', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0eaa0d1e-d30e-4003-9967-d1ba36c3ed80', N'100000242940725', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'd87453e8-bd45-4d1c-9db5-d4db7ff8a010', N'100000429107023', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'59a949cf-133b-4d22-95f7-d5f7701e4e58', N'100000753816437', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5344ad80-cbd6-4c1e-8781-d6f132f6c404', N'100001135282792', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'cac08441-35b5-4f88-a8f0-db19b3003ccb', N'100001863130330', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'9d0527d5-971d-492b-90f5-dbcd0693e05b', N'100001942512043', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'433a2029-74c1-43cd-b690-dd6ea84290a4', N'100001814443755', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'2063fa7a-76f0-4b80-8b12-e329da46a751', N'100001560901582', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8911fd3f-568f-4d5f-a2f1-e3e0a21a8799', N'100001198970142', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'fe792e3f-c03b-41b4-8378-e568a3affc3e', N'100001504912426', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ad97f0b3-ddf3-438f-871c-e6833b17d221', N'100001723242135', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'3c072b18-ca02-4bce-8fee-e8763b5d20e3', N'100001840267034', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'94b1b4f6-d856-4cf5-b3ee-e9938c9ed79c', N'100001977809576', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
GO
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8f2fcc59-5d08-42ae-891e-e9cd6934c0d0', N'100001028621103', N'cd1aa66a-c9e2-43a8-80f9-0fc4925d2f81', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'151323f8-0dc5-4734-8db5-ea1e42f0fad9', N'100002070509601', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'53a8e21a-0404-4b78-8ce4-ee37b5b61eff', N'100001049981810', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7354cc29-3556-467e-a70c-ee8fcdea087c', N'100001505901772', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'bf1d58bd-4595-4ab1-84d8-f007d491f76a', N'100001383634193', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'95b0131f-e7a9-440d-8239-f1f4b2777848', N'100000424337653', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'307d8e5c-74c8-4c03-9c65-f1f5617a20d6', N'100000889372773', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a68efdaa-1c44-4e19-b85c-f2a7e0a27c50', N'100001533621919', N'703284d8-53fc-4405-926a-929cb979d74f', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'89af03f9-d79b-4b52-958b-f3c7833e2b5c', N'100001923148432', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'67ec41ab-45bf-46e5-a228-f404ac0a4181', N'100000918061838', N'40afdad3-06d4-459c-b70e-dfaf58e109c0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'4168f993-f3fa-4ab4-8969-f5d653393319', N'100002079848911', N'6bdd3f68-3021-4cb4-b402-bbdad9bca87e', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'b48c0efe-d4a6-4665-bafa-f66d8abd4148', N'100001784730315', N'a34e153e-61e6-40a8-a7ac-2c6845d2c5e3', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'697fd93b-3a67-453a-9d0b-f791ff605e61', N'100001279514072', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'63f37540-8b7d-48e9-869d-f8a99ad18040', N'100000955068340', N'7314834c-0ab8-4bbb-b193-f3afee66eb98', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5c08f473-6277-4cf2-8bf6-fe5e2a2940a7', N'100001662670363', N'c1126369-56e3-491a-b622-871746b5b188', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 0)
INSERT [dbo].[IMei] ([Id], [IMei], [IdChiTietSP], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7b7e2227-18dc-45c3-b156-ff746c443ffa', N'100000505372943', N'd7063ab4-c49b-449d-ac40-fb815806b2b0', CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), 0)
GO
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'2fde8812-7f69-4361-89d8-000049706153', N'100001198970142', N'426e7ebf-0d46-411c-ab8c-e4bac89c2267', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'31ea9d24-f628-4f71-a20a-074be898735e', N'100002047334329', N'899edf4e-6096-4317-b1c2-97632b162ce3', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), CAST(N'2023-08-08' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'99a63123-de7a-444f-bdd0-0dd70c895faa', N'100001328497797', N'43b4ae4a-11ea-4769-814b-a146ce2a0632', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'f286bd93-d948-4d5f-bede-163ca4446775', N'100001082266537', N'3de67ed2-fad1-4175-8130-da339de147e9', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'986292c7-7ef4-4354-b9ef-1bb8a9ce6098', N'100000212597840', N'eff97e1b-4f25-4cc6-adf3-adae9ddb9001', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'8b90bba1-2ef5-4d83-be1f-1bc5d9ab5c27', N'100000978953118', N'7f45891e-03b2-4961-98ee-1014121b0e57', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'986098dd-666c-4314-9c97-2161de081a27', N'100002087379775', N'2809ec48-1fcd-45d3-bd0d-507db5b67228', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a8795804-c630-428d-82af-28178a4929ab', N'100000189348157', N'6f1a6b0e-7cf4-4c10-bffc-7ae3185bcde9', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ab076011-2690-4c93-92cb-30f170a4e68f', N'100001460682781', N'165a92b5-1d08-4152-9325-92d97ff85999', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e003400e-3190-44c2-a67a-33257e6e6fd7', N'100000535785531', N'20057dfc-0fdc-4f37-8c2c-f460c4be07d9', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5b8b18c1-9254-4187-8cb1-3492e415d96e', N'100001975757892', N'28f9610d-8ecf-435f-898d-55a1044f2237', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'291a72db-fdf4-4931-ac06-359f5470a393', N'100001066204732', N'2d1b73de-6ef7-47d9-8aac-0b2faee368ac', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a7d89c65-a126-47ca-9f41-39a2d26598ee', N'100000179270391', N'1cdc75bf-7ade-41ee-a6e1-b0dd2f828b3a', CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'74a545ef-f930-422b-aa66-3c3917a7f8cf', N'100002040871866', N'447f42b1-1553-4f5c-b1d9-13e496278e96', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e502449d-07b9-4797-831d-4b6b199ce6f3', N'100002064458500', N'682ff9f2-0bbc-4c94-8485-efc275de7747', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ab237592-8ee9-4ef0-942e-4bae3532cb9a', N'100000394534599', N'1ab4dae5-fa56-44f3-a5e3-598d54c542bd', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a612167d-691d-49e5-a3de-4ddd67867d62', N'100000098661241', N'3908e708-6c00-4c8d-85a1-8ea13a9f31f7', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'5b446f9e-c550-427c-bb64-568171c52528', N'100000343834124', N'e03ff2af-e886-4a78-95f7-7020a23c201e', CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'156d340a-536c-4a4f-83ce-5c993d11842e', N'100001847007248', N'b835a836-8289-48a4-a446-4320405135f4', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'c0a82557-d1d0-495b-b206-65a012239f4e', N'100001863130330', N'4f9bd833-18b4-4d67-bc93-67b3f9c17ac0', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'4a76e00c-330e-4c3c-87cb-6cee4e51fe38', N'100000177414863', N'73e6223e-ab01-46cd-b74d-a41d279449b8', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-21' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'cc1ecde2-e513-433a-aa50-711cdb55e4bb', N'100000619065473', N'125a95ad-0194-476d-b340-e1f06300bf40', CAST(N'2023-08-10' AS Date), CAST(N'2023-08-10' AS Date), CAST(N'2023-08-10' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'eb3ee0a6-02ff-416f-8d93-73d66041bf81', N'100001555539570', N'59e5b843-2394-431c-ae10-fcb9990929c6', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'26040f1f-41d2-434c-8258-7de99d980f2b', N'100000273926939', N'59e5b843-2394-431c-ae10-fcb9990929c6', CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), CAST(N'2023-08-11' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'505bb5c8-2be2-4c0c-a736-7f18caf51acb', N'100001863380218', N'221b1050-2cf2-4a20-82c7-e38697cc473b', CAST(N'2023-07-30' AS Date), CAST(N'2023-07-30' AS Date), CAST(N'2023-07-30' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'aca81b7d-ec04-485f-9b5b-7ff843dd41e3', N'100002122623332', N'3de67ed2-fad1-4175-8130-da339de147e9', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'd767910e-1ee5-427d-a6d5-8496a5f093cb', N'100001165819030', N'65139f50-e0ff-4c81-b130-be4fd0c8df9c', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'283150fe-b9e4-4c60-ae91-8f8d6c3502a0', N'100001028621103', N'eabe8870-fc7e-4820-a995-216c5a57e05f', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), CAST(N'2023-08-22' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'00a3126d-ef9d-448a-beda-9018e6d8caf5', N'100001457944392', N'deea29ee-3547-4222-b937-a34c9db3d13c', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e810e9b7-f4cd-4b97-b175-91bccc2729e9', N'100001970964338', N'f5bba9eb-4509-4806-a88b-4268f0d0ce08', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e6ecb09d-bccd-4a2d-a3c5-95537e546ba4', N'100001159833501', N'384dd6e6-bad9-4dcc-a1c2-1578de7b1b0c', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'1aee8e3d-7d20-4ad5-afd4-a07938eeb5e1', N'100001359799775', N'be9509ea-33f5-41ad-9841-537c46427750', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'bbde146e-6cca-48ab-92fb-a20d6889d55f', N'100000673922209', N'b278a28f-b708-463c-95bc-51219b51b10c', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'81ef6acc-8862-4ddd-8afa-a5442372c85b', N'100001279514072', N'165a92b5-1d08-4152-9325-92d97ff85999', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'b5950a11-0521-495c-b22a-bb4a46334182', N'100001187352359', N'fcee0df2-a1bf-4c6a-8986-7ff1860343da', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'59c66f7f-42d7-4859-afb0-bf76228ceded', N'100001613179186', N'426e7ebf-0d46-411c-ab8c-e4bac89c2267', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'6733d479-f3cb-4411-aa17-c0685fa688f9', N'100000102061851', N'2809ec48-1fcd-45d3-bd0d-507db5b67228', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-09' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e199a6a8-78db-43cc-93ce-c9b7a3933223', N'100002043631089', N'a6e1003f-c5a0-437d-a559-293302220bc7', CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), CAST(N'2023-07-26' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'99f0d05b-96ee-4194-be70-cd409d71c34a', N'100000627657828', N'73200287-24e7-4a7f-80c4-6fdef09a7964', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'33899c70-d7dc-4a44-8986-cfa2e89d57ad', N'100000544711494', N'a3d2e90c-1809-4b88-ae3f-933d8156f371', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'78709186-662c-45d2-9708-d40aa40e8264', N'100001164955181', N'048f1439-9cb6-480d-b00e-bcab305961ba', CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), CAST(N'2023-07-31' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0b3a1a1e-750a-495f-a8f0-d41ffea86677', N'100001504912426', N'04e05c8a-4488-4e70-a980-dc40712d1ffb', CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'149d3226-2788-4882-945f-d61862446bac', N'100000346514384', N'3de67ed2-fad1-4175-8130-da339de147e9', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'35d5aeef-5e05-4f17-9147-d8c6dc30d82a', N'100001615367327', N'e03ff2af-e886-4a78-95f7-7020a23c201e', CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), CAST(N'2023-08-09' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'c93b59df-c1c5-46eb-9146-d9f8d3b4d1fc', N'100000889372773', N'2d1b73de-6ef7-47d9-8aac-0b2faee368ac', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'619b7bce-b5bf-4217-8231-dba1b8fc7950', N'100001714360110', N'472d30fe-493c-4984-9acb-f864d3d75c85', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'9648d5ca-2e2c-4b7c-9148-dd9b78e50b34', N'100000861078224', N'12476540-79c4-4f67-b128-3cae23c5121d', CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), CAST(N'2023-07-29' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'6e3c4362-07cc-4e23-822f-ecb25f71848c', N'100001883904066', N'b278a28f-b708-463c-95bc-51219b51b10c', CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), CAST(N'2023-08-08' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'b3f2a9a0-4c6a-425f-9aa6-ed62df19c14d', N'100001135282792', N'4c1a03ae-11a5-4d42-a27f-61b2b4b35072', CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), CAST(N'2023-08-22' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a2067d72-ae8a-4ae0-b458-eec5d904d706', N'100000487798601', N'3de67ed2-fad1-4175-8130-da339de147e9', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'1caa59cc-183f-4922-a6da-f0f84d13dbf9', N'100000252135146', N'486b2ea6-946a-43a5-b220-6f04954479ca', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'd1f08c73-877c-45a8-8781-f40035c6a7e7', N'100000679512548', N'1ab4dae5-fa56-44f3-a5e3-598d54c542bd', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'e3ba8aff-0bfd-495e-960c-f99a4dd84e19', N'100000027189329', N'd2176fa6-2eaa-4bf2-bd11-19ea5dcf9684', CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), CAST(N'2023-07-28' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'63bfdf53-4e56-4f1d-892d-fd9dc34b9b68', N'100001102350104', N'69b8afc1-3505-485e-9ec1-c255d2ab5383', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'7ca91099-28d5-413a-a18b-ffa159b88306', N'100001363426963', N'20057dfc-0fdc-4f37-8c2c-f460c4be07d9', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 1)
INSERT [dbo].[IMeiDaBan] ([Id], [IMei], [IdChiTietHD], [NgayBan], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'eb9cb2ee-1f5e-43f5-9008-ffdeb3cbbe21', N'100000242940725', N'fc88aa8f-f62c-4a1c-9e13-014885b0c2dc', CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), CAST(N'2023-08-22' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([Id], [NgaySinh], [Sdt], [DiaChi], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'31849c7d-203d-4add-ac6b-48a87202e10b', CAST(N'2003-01-01' AS Date), N'0932765463', N'31 Hoàng Quốc Việt', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, N'Trần Minh Quang', 0)
INSERT [dbo].[KhachHang] ([Id], [NgaySinh], [Sdt], [DiaChi], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'625eedaa-df43-4441-b60d-51cfa5293b94', CAST(N'2002-03-24' AS Date), N'0999999999', N'Quảng Ninh', CAST(N'2023-07-17' AS Date), CAST(N'2023-07-17' AS Date), 2, N'Nguyễn Tuấn Việt', 0)
INSERT [dbo].[KhachHang] ([Id], [NgaySinh], [Sdt], [DiaChi], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'b9e9281a-9ab1-459c-972e-5d39b3d3dac2', CAST(N'2000-12-24' AS Date), N'0969852926', N'Bắc Giang', CAST(N'2023-07-27' AS Date), CAST(N'2023-07-27' AS Date), 3, N'Phạm Thị Khánh Linh', 0)
INSERT [dbo].[KhachHang] ([Id], [NgaySinh], [Sdt], [DiaChi], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'0dda8fde-f563-4da2-ab66-84af109c5e94', CAST(N'2002-03-13' AS Date), N'0111111111', N'Quảng Ninh', CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 6, N'Nguyễn Văn Khởi', 0)
INSERT [dbo].[KhachHang] ([Id], [NgaySinh], [Sdt], [DiaChi], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'011f4656-b891-4583-badd-e67edf892eae', CAST(N'1997-05-05' AS Date), N'0333333333', N'Hai Bà Trưng Hà Nội', CAST(N'2023-07-25' AS Date), CAST(N'2023-07-25' AS Date), 4, N'Phạm Thị Thơm', 0)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 

INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'85ab422e-a78b-4641-9752-1f21578dd334', CAST(500000 AS Decimal(20, 0)), 10, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-20' AS Date), 2, 1)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'17ac36aa-bc5c-4650-b9a0-3d27b56683e7', CAST(100000 AS Decimal(20, 0)), 5, CAST(N'2023-08-18' AS Date), CAST(N'2023-08-18' AS Date), 2, 6)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'd2dfc5eb-73e2-45e0-a034-4cc935e9abca', CAST(300000 AS Decimal(20, 0)), 0, CAST(N'2023-07-26' AS Date), CAST(N'2023-07-29' AS Date), 2, 2)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'bba07cb9-350d-47b9-9767-899b6304cfda', CAST(1000000 AS Decimal(20, 0)), 1, CAST(N'2023-08-21' AS Date), CAST(N'2023-08-21' AS Date), 2, 7)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'c1985b4f-60b9-4c01-9321-c3d3a3dcf41c', CAST(100000 AS Decimal(20, 0)), 10, CAST(N'2023-07-25' AS Date), CAST(N'2023-07-28' AS Date), 2, 3)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'c7550932-aabc-4e87-a040-d750a4d92131', CAST(300000 AS Decimal(20, 0)), 8, CAST(N'2023-08-08' AS Date), CAST(N'2023-08-10' AS Date), 2, 4)
INSERT [dbo].[KhuyenMai] ([Id], [SoTienGiam], [SoLuong], [NgayBatDau], [NgayKetThuc], [TrangThai], [NumOrder]) VALUES (N'2ab62e03-501e-4f78-88ba-e29932bf9441', CAST(200000 AS Decimal(20, 0)), 10, CAST(N'2023-08-01' AS Date), CAST(N'2023-08-05' AS Date), 2, 5)
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[ManHinh] ON 

INSERT [dbo].[ManHinh] ([Id], [DoPhanGiai], [Inch], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'c0a6c5de-61d2-47b9-a31e-484c05adec42', N'WQXGA 16:10 IPS PoL 99%DCI-P3', 16, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[ManHinh] ([Id], [DoPhanGiai], [Inch], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'9f0eb76a-9557-40c7-aad7-49bd6b32f161', N'FHD IPS ComfyView LED LCD', 14, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[ManHinh] ([Id], [DoPhanGiai], [Inch], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'd7fd200f-1e97-43b5-ac9e-855d9fe5e212', N'FHD 144Hz', 16, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
INSERT [dbo].[ManHinh] ([Id], [DoPhanGiai], [Inch], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'83d51f04-3998-41f4-bf34-a779c87ed09e', N'FHD+WVA Anti-Glare 60Hz', 15.6, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[ManHinh] ([Id], [DoPhanGiai], [Inch], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'8710bb21-397f-4705-bb51-e25e20390c4b', N'FHD 120Hz WVA', 15.6, CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
SET IDENTITY_INSERT [dbo].[ManHinh] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'016664c7-7822-4e82-8618-70cdd41556fc', N'Màu xám', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[MauSac] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'a4914416-5b4f-4c45-aad2-99238eee29a0', N'Màu xanh', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
INSERT [dbo].[MauSac] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'51a60013-2a9c-46af-9914-b75f4c1e771f', N'Màu bạc', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[MauSac] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'70d36f7b-4d3e-4829-9191-ce8dd699095f', N'Màu đen', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[MauSac] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'8f6ea32c-4f94-4fdb-bd11-d4743941f8aa', N'Màu trắng', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([Id], [IdCV], [GioiTinh], [NgaySinh], [Sdt], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'2efa6406-1890-4fb0-a0d4-52b04289a803', N'5f2629e3-d4b9-403b-a132-62c4377feffd', N'Nữ', CAST(N'2000-01-15' AS Date), N'0384365755', N'Hà Nội', N'88888888', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, N'Lê Văn Tùng', 1)
INSERT [dbo].[NhanVien] ([Id], [IdCV], [GioiTinh], [NgaySinh], [Sdt], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'c212ed85-493b-4b1b-aa09-77b4b72c3f57', N'5f2629e3-d4b9-403b-a132-62c4377feffd', N'Nam', CAST(N'1998-01-01' AS Date), N'0373654374', N'Hà Nội', N'88888888', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, N'Trần Văn Thái', 1)
INSERT [dbo].[NhanVien] ([Id], [IdCV], [GioiTinh], [NgaySinh], [Sdt], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'a323127f-4e8d-4abe-b223-90f4f948ce36', N'28e1793d-2b2e-4377-8327-b27c8b26752f', N'Nữ', CAST(N'2001-01-05' AS Date), N'0374646777', N'Hà Nội', N'88888888', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, N'Nguyễn Thu Hương', 1)
INSERT [dbo].[NhanVien] ([Id], [IdCV], [GioiTinh], [NgaySinh], [Sdt], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'e7753662-4f8d-4627-8b5b-a36541d88cc8', N'28e1793d-2b2e-4377-8327-b27c8b26752f', N'Nam', CAST(N'1999-05-05' AS Date), N'0376325364', N'Hà Nội', N'88888888', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, N'Trần Thị Linh', 1)
INSERT [dbo].[NhanVien] ([Id], [IdCV], [GioiTinh], [NgaySinh], [Sdt], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NumOrder], [HoTen], [TrangThai]) VALUES (N'd618597a-f5b3-4250-8fec-ded826b99377', N'28e1793d-2b2e-4377-8327-b27c8b26752f', N'Nam', CAST(N'1999-05-05' AS Date), N'0378948764', N'Hà Nội', N'88888888', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, N'Phạm Quang Dương', 1)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[NSX] ON 

INSERT [dbo].[NSX] ([Id], [Ten], [QuocGia], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'76f4f906-2dd9-4724-97c5-126d94f2de01', N'CT Apple', N'Mỹ', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[NSX] ([Id], [Ten], [QuocGia], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'd9a54e5a-d8f5-4803-8ba0-3a4b787875ef', N'CT HP', N'Mỹ', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
INSERT [dbo].[NSX] ([Id], [Ten], [QuocGia], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'ac4aa0fb-2745-4da9-9011-3f10a5b6e978', N'CT MSI', N'Đài Loan', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[NSX] ([Id], [Ten], [QuocGia], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'dc6ad5fb-764d-4e72-ae97-62445d361364', N'CT Acer', N'Đài Loan', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
INSERT [dbo].[NSX] ([Id], [Ten], [QuocGia], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'52eb796e-5d45-41ab-b8b9-e8b805cc56ea', N'CT Dell', N'Hoa Kỳ', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
SET IDENTITY_INSERT [dbo].[NSX] OFF
GO
SET IDENTITY_INSERT [dbo].[RAM] ON 

INSERT [dbo].[RAM] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'c3f04112-627d-432a-b8de-1777b40c5fb9', N'RAM 16GB DDR4', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[RAM] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'80da6c0a-02d9-48fe-87e8-221c4a2e37a8', N'RAM 16GB DDR5', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[RAM] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'666af59c-db60-4176-b84a-aaf4bc8f126f', N'RAM 16GB DDR3L', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[RAM] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'9b9469c5-4a3c-4737-8cae-b8ab17e44a56', N'RAM 8GB DDR4', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
INSERT [dbo].[RAM] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'bff9b107-008a-4dd3-9d94-f66da52c24db', N'RAM 16GB LPDDR5', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
SET IDENTITY_INSERT [dbo].[RAM] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'65b3751c-7b5d-4cd5-8c89-5ff0270963f4', N'Laptop Acer Aspire 3 A315-56-38B1', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
INSERT [dbo].[SanPham] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'5d8cc3e7-2904-4324-a035-6f3b5c07a78f', N'Laptop Dell Vostro 3520 5M2TT2', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
INSERT [dbo].[SanPham] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'279964ab-2975-43a2-bf8c-9bde2d64ff37', N'Laptop MSI GS63 Thin 11SC 664VN', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[SanPham] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'08e3cbb3-60e9-48e4-ae13-cc048457d0f1', N'Laptop HP 14s-dq2644TU 7C0W6PA', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[SanPham] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'10a76c58-bd7d-4059-a314-e6efb3b22346', N'Laptop MacBook Pro 16 M1 Max', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 5, 0)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[SSD] ON 

INSERT [dbo].[SSD] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'f0d85033-738c-474f-a9e5-14d93f83ec0d', N'SSD 512GB M2 SATA', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 3, 0)
INSERT [dbo].[SSD] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'67c93247-d477-4e58-ae48-47125f928887', N'SSD 256GB M2 SATA', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 2, 0)
INSERT [dbo].[SSD] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'16a0cdf4-bb82-42b8-96fc-cab1bb2bd9c2', N'SSD 256GB PCle NVMe', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 4, 0)
INSERT [dbo].[SSD] ([Id], [Ten], [NgayTao], [NgaySua], [NumOrder], [TrangThai]) VALUES (N'b3d62084-9cfe-4dc4-bcc5-dfca9467e3df', N'SSD 512GB PCle NVMe', CAST(N'2023-07-15' AS Date), CAST(N'2023-07-15' AS Date), 1, 0)
SET IDENTITY_INSERT [dbo].[SSD] OFF
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT ((0)) FOR [Dongia]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT ((0)) FOR [ThanhTien]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT ((0)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[ChiTietHD] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [GiaNhap]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[DongSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[DongSP] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[DongSP] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[DongSP] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [LyDo]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [ThanhTien]
GO
ALTER TABLE [dbo].[IMei] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[IMei] ADD  DEFAULT (abs(checksum(newid()))%(900000000000000.)+(100000000000000.)) FOR [IMei]
GO
ALTER TABLE [dbo].[IMei] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[IMei] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[IMei] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[IMeiDaBan] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[IMeiDaBan] ADD  DEFAULT (getdate()) FOR [NgayBan]
GO
ALTER TABLE [dbo].[IMeiDaBan] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[IMeiDaBan] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[IMeiDaBan] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [SoTienGiam]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[RAM] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[RAM] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[RAM] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[RAM] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[SSD] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SSD] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SSD] ADD  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SSD] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([IdHD])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdBH])
REFERENCES [dbo].[BaoHanh] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdCPU])
REFERENCES [dbo].[CPU] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdDongSP])
REFERENCES [dbo].[DongSP] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdManHinh])
REFERENCES [dbo].[ManHinh] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdNSX])
REFERENCES [dbo].[NSX] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdRAM])
REFERENCES [dbo].[RAM] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdSP])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdSSD])
REFERENCES [dbo].[SSD] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdNV])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[IMei]  WITH CHECK ADD FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[IMeiDaBan]  WITH CHECK ADD  CONSTRAINT [FK__IMeiDaBan__IdHD] FOREIGN KEY([IdChiTietHD])
REFERENCES [dbo].[ChiTietHD] ([Id])
GO
ALTER TABLE [dbo].[IMeiDaBan] CHECK CONSTRAINT [FK__IMeiDaBan__IdHD]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([IdCV])
REFERENCES [dbo].[ChucVu] ([Id])
GO
USE [master]
GO
ALTER DATABASE [QuanLyCuaHangLaptop] SET  READ_WRITE 
GO
