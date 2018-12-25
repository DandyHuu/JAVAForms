-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 25, 2018 lúc 09:57 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `csdlbigless`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh_muc`
--

CREATE TABLE `danh_muc` (
  `id` int(11) NOT NULL,
  `Ten_Danh__Muc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `danh_muc`
--

INSERT INTO `danh_muc` (`id`, `Ten_Danh__Muc`) VALUES
(1, 'Truyện thiếu nhi'),
(2, 'Truyện 18+'),
(3, 'Sách tri thức người xưa'),
(4, 'Khoa học - Công nghệ'),
(5, 'Đời sống xã hội'),
(6, 'Truyện MA'),
(7, 'Truyện cổ tích');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `Ma_Khach_hang` int(11) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Ten_Khach_hang` varchar(200) NOT NULL,
  `Dia_Chi` varchar(100) NOT NULL,
  `Phone` int(20) NOT NULL,
  `Tien_dat_coc` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`Ma_Khach_hang`, `Password`, `Ten_Khach_hang`, `Dia_Chi`, `Phone`, `Tien_dat_coc`) VALUES
(1, '123', 'Nguyễn Văn C', 'Hà Bắc', 123456789, 900000),
(2, '456', 'Nguyễn Văn B', 'Hà Nội', 123456789, 1000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_ph`
--

CREATE TABLE `nha_ph` (
  `Ma_NXB` int(11) NOT NULL,
  `Ten_NXB` varchar(200) NOT NULL,
  `Dia_Chi` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Ghi_Chu` text NOT NULL,
  `Logo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nha_ph`
--

INSERT INTO `nha_ph` (`Ma_NXB`, `Ten_NXB`, `Dia_Chi`, `Email`, `Ghi_Chu`, `Logo`) VALUES
(1, 'Kim đồng', 'Hà nội', 'kimdong@gmail.com', 'ádasdawdawdaw', 'logo.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_muon`
--

CREATE TABLE `phieu_muon` (
  `Ma_Phieu_muon` int(11) NOT NULL,
  `Ma_Khach_hang` int(11) NOT NULL,
  `Ma_Sach` int(11) NOT NULL,
  `Ngay_muon` date NOT NULL,
  `Han_tra` date NOT NULL,
  `Ngaytra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quan_tri`
--

CREATE TABLE `quan_tri` (
  `Ma_Admin` int(11) NOT NULL,
  `Ten_nguoi_dung` varchar(200) NOT NULL,
  `Ten_dang_nhap` varchar(200) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Role` tinyint(1) NOT NULL,
  `Avatar` varchar(200) NOT NULL,
  `Phone` int(11) NOT NULL,
  `Thong_Tin` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quan_tri`
--

INSERT INTO `quan_tri` (`Ma_Admin`, `Ten_nguoi_dung`, `Ten_dang_nhap`, `Password`, `Role`, `Avatar`, `Phone`, `Thong_Tin`) VALUES
(1, 'AD_MIN', 'admin', '123', 0, 'E:\\Ảnh xàm\\huou.png', 123456789, 'Loneliness is a revelry, solitary a magnificence, emptiness a quality, being single a noble sentiment, a. . . Why are there tears in my eyes. . . *woof* . . . This canned food tastes good, have one yo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `Ma_Sach` int(11) NOT NULL,
  `Ten_Sach` varchar(200) NOT NULL,
  `Ten_Tac_gia` varchar(200) NOT NULL,
  `Nha_xb` varchar(200) NOT NULL,
  `Gia_tien` int(11) NOT NULL,
  `So_luong` int(11) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `id_cate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`Ma_Sach`, `Ten_Sach`, `Ten_Tac_gia`, `Nha_xb`, `Gia_tien`, `So_luong`, `Name`, `id_cate`) VALUES
(1, 'doremen', 'fuji', 'KIM Đồng', 10000, 1, 'Yasuo 15 GG', NULL),
(2, 'Thám tử lừng danh Conan', 'Conan doye', 'SGD', 16000, 2, 'Yasuo 15 GG', NULL),
(3, 'adsdadsadas', 'ádasdasdads', 'sadasd', 123123, 12312312, '', 4);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`Ma_Khach_hang`);

--
-- Chỉ mục cho bảng `nha_ph`
--
ALTER TABLE `nha_ph`
  ADD PRIMARY KEY (`Ma_NXB`);

--
-- Chỉ mục cho bảng `phieu_muon`
--
ALTER TABLE `phieu_muon`
  ADD PRIMARY KEY (`Ma_Phieu_muon`);

--
-- Chỉ mục cho bảng `quan_tri`
--
ALTER TABLE `quan_tri`
  ADD PRIMARY KEY (`Ma_Admin`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`Ma_Sach`),
  ADD KEY `id_danh_muc` (`id_cate`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danh_muc`
--
ALTER TABLE `danh_muc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `Ma_Khach_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `nha_ph`
--
ALTER TABLE `nha_ph`
  MODIFY `Ma_NXB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `phieu_muon`
--
ALTER TABLE `phieu_muon`
  MODIFY `Ma_Phieu_muon` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `quan_tri`
--
ALTER TABLE `quan_tri`
  MODIFY `Ma_Admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `Ma_Sach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`id_cate`) REFERENCES `danh_muc` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
