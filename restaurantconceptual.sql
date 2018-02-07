-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 07, 2018 lúc 05:05 PM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurantconceptual`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `date_of_booking` varchar(100) NOT NULL,
  `number_in_party` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`booking_id`, `date_of_booking`, `number_in_party`, `customer_id`, `table_number`) VALUES
(1, '01/01/2018', 10, 1, 1),
(3, '10/10/2018', 30, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `cell_number` varchar(100) NOT NULL,
  `customer_first_name` varchar(100) NOT NULL,
  `customer_surname` varchar(100) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `other_customer_details` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`customer_id`, `cell_number`, `customer_first_name`, `customer_surname`, `email_address`, `other_customer_details`, `phone_number`) VALUES
(1, '030842123', 'Nguyen Van', 'A', 'default@gmail.com', 'a', '0123456789'),
(3, '030842178', 'Ta Ngoc', 'C', 'test@gmail.com', 'c', '0321654789');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ingredients`
--

CREATE TABLE `ingredients` (
  `ingredient_id` int(11) NOT NULL,
  `ingredient_name` varchar(100) NOT NULL,
  `ingredient_type_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ingredients`
--

INSERT INTO `ingredients` (`ingredient_id`, `ingredient_name`, `ingredient_type_code`) VALUES
(1, 'Buffalo', 1),
(3, 'Mushroom', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ingredient_type`
--

CREATE TABLE `ingredient_type` (
  `ingredient_type_code` int(11) NOT NULL,
  `ingredient_type_decscription` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ingredient_type`
--

INSERT INTO `ingredient_type` (`ingredient_type_code`, `ingredient_type_decscription`) VALUES
(1, 'Dong vat'),
(3, 'Huu co');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `menu_date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`menu_id`, `menu_date`) VALUES
(1, '01/01/2018'),
(3, '01/01/2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_item`
--

CREATE TABLE `menu_item` (
  `menu_item_id` int(11) NOT NULL,
  `menu_item_decscription` varchar(100) NOT NULL,
  `menu_item_price` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `menu_item`
--

INSERT INTO `menu_item` (`menu_item_id`, `menu_item_decscription`, `menu_item_price`, `menu_id`) VALUES
(1, 'Description1', 50000, 1),
(3, 'Description3', 150000, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_item_ingredient`
--

CREATE TABLE `menu_item_ingredient` (
  `menu_item_ingredient_id` int(11) NOT NULL,
  `item_quantity` int(11) NOT NULL,
  `ingredient_id` int(11) NOT NULL,
  `menu_item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `menu_item_ingredient`
--

INSERT INTO `menu_item_ingredient` (`menu_item_ingredient_id`, `item_quantity`, `ingredient_id`, `menu_item_id`) VALUES
(1, 10, 1, 1),
(3, 35, 3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_date_time` varchar(100) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`order_id`, `order_date_time`, `staff_id`, `table_number`) VALUES
(1, '01/01/2018', 1, 1),
(3, '01/01/2020', 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_menu_item`
--

CREATE TABLE `order_menu_item` (
  `order_menu_item_id` int(11) NOT NULL,
  `order_menu_item_comments` varchar(100) NOT NULL,
  `order_menu_item_quantity` int(11) NOT NULL,
  `menu_item_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_menu_item`
--

INSERT INTO `order_menu_item` (`order_menu_item_id`, `order_menu_item_comments`, `order_menu_item_quantity`, `menu_item_id`, `order_id`) VALUES
(1, 'Good', 1, 1, 1),
(3, 'Not bad', 3, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `staff_first_name` varchar(100) NOT NULL,
  `staff_last_name` varchar(100) NOT NULL,
  `staff_role_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`staff_id`, `staff_first_name`, `staff_last_name`, `staff_role_code`) VALUES
(1, 'Ta Ngoc', 'Quy', 3),
(3, 'Ta Quang', 'Quyen', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff_role`
--

CREATE TABLE `staff_role` (
  `staff_role_code` int(11) NOT NULL,
  `staff_role_decscription` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff_role`
--

INSERT INTO `staff_role` (`staff_role_code`, `staff_role_decscription`) VALUES
(2, 'Truong phong'),
(3, 'Giam doc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tables`
--

CREATE TABLE `tables` (
  `table_number` int(11) NOT NULL,
  `table_details` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tables`
--

INSERT INTO `tables` (`table_number`, `table_details`) VALUES
(1, 'Le tan'),
(3, 'Thu ngan');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `FKlnnelfsha11xmo2ndjq66fvro` (`customer_id`),
  ADD KEY `FK9555p2kei1ueoyug05cbe2o4o` (`table_number`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Chỉ mục cho bảng `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`ingredient_id`),
  ADD KEY `FK11dlmmhvhhx7wtqc1tjblh8uw` (`ingredient_type_code`);

--
-- Chỉ mục cho bảng `ingredient_type`
--
ALTER TABLE `ingredient_type`
  ADD PRIMARY KEY (`ingredient_type_code`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu_id`);

--
-- Chỉ mục cho bảng `menu_item`
--
ALTER TABLE `menu_item`
  ADD PRIMARY KEY (`menu_item_id`),
  ADD KEY `FKcdkmv42yhn6udah6ug8rsymfl` (`menu_id`);

--
-- Chỉ mục cho bảng `menu_item_ingredient`
--
ALTER TABLE `menu_item_ingredient`
  ADD PRIMARY KEY (`menu_item_ingredient_id`),
  ADD KEY `FK4e7g2hj1ihq6jj53ru8oc3qbo` (`ingredient_id`),
  ADD KEY `FKpiy0qugnavbufnc1d6rmcs8pr` (`menu_item_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FK4ery255787xl56k025fyxrqe9` (`staff_id`),
  ADD KEY `FKg06usf5wtg8wqi8uk4bimy99f` (`table_number`);

--
-- Chỉ mục cho bảng `order_menu_item`
--
ALTER TABLE `order_menu_item`
  ADD PRIMARY KEY (`order_menu_item_id`),
  ADD KEY `FKoudm2juuy5n0gojkem824fy2k` (`menu_item_id`),
  ADD KEY `FKnc7x6ng8d417v16clrrsd73pk` (`order_id`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD KEY `FKhvg99wwoil74inhfd4otwm0i4` (`staff_role_code`);

--
-- Chỉ mục cho bảng `staff_role`
--
ALTER TABLE `staff_role`
  ADD PRIMARY KEY (`staff_role_code`);

--
-- Chỉ mục cho bảng `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`table_number`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `ingredient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `ingredient_type`
--
ALTER TABLE `ingredient_type`
  MODIFY `ingredient_type_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `menu`
--
ALTER TABLE `menu`
  MODIFY `menu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `menu_item`
--
ALTER TABLE `menu_item`
  MODIFY `menu_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `menu_item_ingredient`
--
ALTER TABLE `menu_item_ingredient`
  MODIFY `menu_item_ingredient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `order_menu_item`
--
ALTER TABLE `order_menu_item`
  MODIFY `order_menu_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `staff_role`
--
ALTER TABLE `staff_role`
  MODIFY `staff_role_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `tables`
--
ALTER TABLE `tables`
  MODIFY `table_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FK9555p2kei1ueoyug05cbe2o4o` FOREIGN KEY (`table_number`) REFERENCES `tables` (`table_number`),
  ADD CONSTRAINT `FKlnnelfsha11xmo2ndjq66fvro` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Các ràng buộc cho bảng `ingredients`
--
ALTER TABLE `ingredients`
  ADD CONSTRAINT `FK11dlmmhvhhx7wtqc1tjblh8uw` FOREIGN KEY (`ingredient_type_code`) REFERENCES `ingredient_type` (`ingredient_type_code`);

--
-- Các ràng buộc cho bảng `menu_item`
--
ALTER TABLE `menu_item`
  ADD CONSTRAINT `FKcdkmv42yhn6udah6ug8rsymfl` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`);

--
-- Các ràng buộc cho bảng `menu_item_ingredient`
--
ALTER TABLE `menu_item_ingredient`
  ADD CONSTRAINT `FK4e7g2hj1ihq6jj53ru8oc3qbo` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`),
  ADD CONSTRAINT `FKpiy0qugnavbufnc1d6rmcs8pr` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_item` (`menu_item_id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK4ery255787xl56k025fyxrqe9` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  ADD CONSTRAINT `FKg06usf5wtg8wqi8uk4bimy99f` FOREIGN KEY (`table_number`) REFERENCES `tables` (`table_number`);

--
-- Các ràng buộc cho bảng `order_menu_item`
--
ALTER TABLE `order_menu_item`
  ADD CONSTRAINT `FKnc7x6ng8d417v16clrrsd73pk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `FKoudm2juuy5n0gojkem824fy2k` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_item` (`menu_item_id`);

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FKhvg99wwoil74inhfd4otwm0i4` FOREIGN KEY (`staff_role_code`) REFERENCES `staff_role` (`staff_role_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
