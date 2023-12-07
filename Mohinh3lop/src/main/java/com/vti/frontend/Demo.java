package com.vti.frontend;

import com.vti.backend.controller.Controller;
import com.vti.entity.User;
import com.vti.utils.JDBCUTILS;
import com.vti.utils.ScannerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {

        private static Controller controller = new Controller();
        private static String leftAlignmentFormat = "| %-5d | %-10s | %-15s | %-10s | %n";


        public static void main (String[]args) throws SQLException, ClassNotFoundException {


            while (true) {
                try {
                    System.out.println("1. In ra tất cả các employee & Manager trong project");
                    System.out.println("2. Đăng nhập tài khoản ADMIN");
                    System.out.println("3. Tạo tài khoản employee");
                    System.out.println("4. thoát khỏi chương trình");
                    System.out.println("Chọn chức năng bạn muốn: ");
                    int menuChoose = ScannerUtils.inputInt();
                    switch (menuChoose) {
                        case 1:
                            question2();
                            break;
                        case 2:
                            question3();
                            break;
                        case 3:
                            question4();
                            break;
                        case 4:
                            System.out.println("kết thúc chương trình...");
                            return;
                        default:
                            System.out.println("nhập sai! xin vui lòng nhập lại");
                            break;
                    }


                } catch (ClassNotFoundException e) {
                    System.err.println(e.getMessage());
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        public static void question2 () throws ClassNotFoundException, SQLException {
            System.out.println("nhap projectId: ");
            int projectId = ScannerUtils.inputInt();
            System.out.printf("| %-5s | %-14s | %-22s | %-10s | %n", "ID", "FULLNAME", "EMAIL", "ROLE");

            for (User user : controller.getListUser()) {
                if (user.getProjectId() == projectId) {
                    System.out.printf(leftAlignmentFormat, user.getId(), user.getFullName(), user.getEmail(),
                            user.getRole());
                }

            }
        }

        public static void question3 () throws ClassNotFoundException, SQLException {
            System.out.println("Bạn phải nhập thông tin tài khoản ADMIN");
            System.out.println("nhap email: ");
            String email = ScannerUtils.inputEmail();
            System.out.println("nhap password: ");
            String password = ScannerUtils.inputPassword1();
            User user = controller.isLogin(email, password);
            if (user != null && user.getRole() == User.Role.ADMIN) {
                System.out.println("đăng nhập thành công");
            } else {
                System.out.println("đăng nhập không thành công");
            }
        }

        public static void question4 () throws ClassNotFoundException, SQLException, Exception {
            System.out.println("Bạn phải nhập thông tin tài khoản ADMIN");
            System.out.println("nhap email: ");
            String email = ScannerUtils.inputEmail();
            System.out.println("nhap password: ");
            String password = ScannerUtils.inputPassword1();
            User user = controller.isLogin(email, password);
            if (user != null && user.getRole() == User.Role.ADMIN) {
                System.out.println("đăng nhập thành công");
                System.out.println("bat dau tao employee");
                System.out.println("nhap fullname: ");
                String fullName = ScannerUtils.inputFullname();
                System.out.println("nhap email: ");
                String email1 = ScannerUtils.inputEmail();

                controller.createEmployee(fullName, email1);
            } else {
                System.out.println("đăng nhập không thành công");
            }


        }
    }


