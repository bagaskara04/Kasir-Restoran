-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Jan 2022 pada 05.14
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasirrestoran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `id_transaksi` varchar(120) NOT NULL,
  `makanan` varchar(30) NOT NULL,
  `minuman` varchar(30) NOT NULL,
  `hargamakan` varchar(100) NOT NULL,
  `hargaminum` varchar(100) NOT NULL,
  `jmlh_makanan` varchar(50) NOT NULL,
  `jmlh_minuman` varchar(50) NOT NULL,
  `total` varchar(100) NOT NULL,
  `jmlh_bayar` varchar(100) NOT NULL,
  `jmlh_kembalian` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`id_transaksi`, `makanan`, `minuman`, `hargamakan`, `hargaminum`, `jmlh_makanan`, `jmlh_minuman`, `total`, `jmlh_bayar`, `jmlh_kembalian`) VALUES
('R0001', 'Bakmi Jawa', 'Es Dawet', '12000', '8000', '1', '1', '20000', '30000', 'Rp. 10000'),
('R0002', 'Bakmi Jawa', 'Es Teler', '12000', '12000', '1', '1', '24000', '30000', 'Rp. 6000'),
('R0003', 'Sate Ayam', 'Es Teh', '15000', '6000', '1', '2', '27000', '50000', 'Rp. 23000'),
('R0004', 'Nasi Goreng', 'Es Teler', '15000', '12000', '1', '1', '27000', '30000', 'Rp. 3000'),
('R0005', 'Nasi Goreng', 'Es Teler', '15000', '12000', '1', '1', '27000', '30000', 'Rp. 3000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(30) CHARACTER SET latin1 NOT NULL,
  `password` varchar(30) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin'),
('user', 'user');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_makanan`
--

CREATE TABLE `tb_makanan` (
  `nama_makanan` varchar(30) NOT NULL,
  `harga` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_makanan`
--

INSERT INTO `tb_makanan` (`nama_makanan`, `harga`) VALUES
('Bakmi Jawa', '12000'),
('Gudeg', '15000'),
('Nasi Goreng', '15000'),
('Sate Ayam', '15000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_minuman`
--

CREATE TABLE `tb_minuman` (
  `nama_minuman` varchar(30) NOT NULL,
  `harga` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_minuman`
--

INSERT INTO `tb_minuman` (`nama_minuman`, `harga`) VALUES
('Es Dawet', '8000'),
('Es Teh', '6000'),
('Es Teler', '12000'),
('STMJ', '14000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `tb_makanan`
--
ALTER TABLE `tb_makanan`
  ADD PRIMARY KEY (`nama_makanan`);

--
-- Indeks untuk tabel `tb_minuman`
--
ALTER TABLE `tb_minuman`
  ADD PRIMARY KEY (`nama_minuman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
