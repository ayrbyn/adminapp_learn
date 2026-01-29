-- =====================
-- TABLE: roti
-- =====================
CREATE TABLE roti (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nama_roti VARCHAR(255) NOT NULL,
  kategori VARCHAR(255) NOT NULL,
  harga DECIMAL(38,2) NOT NULL,
  stok INT NOT NULL,
  status VARCHAR(20) NOT NULL
);

-- =====================
-- TABLE: transaksi
-- =====================
CREATE TABLE transaksi (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  tanggal_transaksi DATETIME(6) NOT NULL,
  total_harga DECIMAL(38,2),
  metode_pembayaran VARCHAR(255) NOT NULL
);

-- =====================
-- TABLE: produksi_roti
-- =====================
CREATE TABLE produksi_roti (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  roti_id BIGINT NOT NULL,
  tanggal_produksi DATE NOT NULL,
  jumlah_produksi INT NOT NULL,
  CONSTRAINT fk_produksi_roti
    FOREIGN KEY (roti_id) REFERENCES roti(id)
);

-- =====================
-- TABLE: detail_transaksi
-- =====================
CREATE TABLE detail_transaksi (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  transaksi_id BIGINT NOT NULL,
  roti_id BIGINT NOT NULL,
  jumlah INT NOT NULL,
  harga_saat_transaksi DECIMAL(38,2),
  subtotal DECIMAL(38,2),
  CONSTRAINT fk_detail_transaksi_transaksi
    FOREIGN KEY (transaksi_id) REFERENCES transaksi(id),
  CONSTRAINT fk_detail_transaksi_roti
    FOREIGN KEY (roti_id) REFERENCES roti(id)
);

-- =====================
-- OPTIONAL: DATA AWAL
-- =====================
INSERT INTO roti (nama_roti, kategori, harga, stok, status) VALUES
('roti tawar kupas','tawar',10000.00,39,'TERSEDIA'),
('roti kelapa','manis',5000.00,28,'TERSEDIA'),
('roti nanas','manis',12000.00,45,'TERSEDIA');
