
import dao.book.BookDAO;
import dao.order.OrderDAO;
import entity.book.Book;
import entity.order.Order;
import entity.person.customer.CustomerMember;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zOzDarKzOz
 */
public class MyTest {

    /*Test chuc nang Tim kiem sach*/
    //Kiem thu cateogry "Truyen ngan" cua 1 sach bat ky trong danh sach ket qua 
    //khi lay sach theo categoy "Truyen ngan" voi category cua sach dau tien 
    //trong danh sach ket qua tim kiem sach theo category "Truyen ngan" 
    //voi ten la "a"
    // Ket qua mong muon: Pass
    @Test
    public void SearchTest1() {
        Book book1 = new BookDAO().getListOfBookByIdCategory(2).get(3);
        Book book2 = new BookDAO().getListOfBookByNameAndIdCategory("a", 2).get(0);
        Assert.assertEquals(book1.getCategory().getName(), book2.getCategory().getName());
    }

    //Kiem thu cateogry "Truyen ngan" cua 1 sach bat ky trong danh sach ket qua 
    //khi lay sach theo categoy "Truyen ngan" voi category cua sach dau tien 
    //trong danh sach ket qua tim kiem sach theo category "Tinh cam" 
    //voi ten la "a"
    // Ket qua mong muon: Fail
    @Test
    public void SearchTest2() {
        Book book1 = new BookDAO().getListOfBookByIdCategory(2).get(3);
        Book book2 = new BookDAO().getListOfBookByNameAndIdCategory("a", 1).get(0);
        Assert.assertEquals(book1.getCategory().getName(), book2.getCategory().getName());
    }

    //Kiem thu bookset "Danh cho thieu nhi" cua 1 sach bat ky trong danh sach ket qua 
    //khi lay sach theo categoy "Danh cho thieu nhi" voi category cua sach dau tien 
    //trong danh sach ket qua tim kiem sach theo category "Danh cho thieu nhi" 
    //voi ten la "a"
    // Ket qua mong muon: Pass
    @Test
    public void SearchTest3() {
        Book book1 = new BookDAO().getListOfBookByIdBookSet(1).get(2);
        Book book2 = new BookDAO().getListOfBookByNameAndIdBookSet("a", 1).get(0);
        Assert.assertEquals(book1.getSet().getName(), book2.getSet().getName());
    }

    //Kiem thu bookset "Danh cho thieu nhi" cua 1 sach bat ky trong danh sach ket qua 
    //khi lay sach theo categoy "Danh cho thieu nhi" voi category cua sach dau tien 
    //trong danh sach ket qua tim kiem sach theo category "Danh cho nghien cuu khoa hoc" 
    //voi ten la "a"
    // Ket qua mong muon: Fail
    @Test
    public void SearchTest4() {
        Book book1 = new BookDAO().getListOfBookByIdBookSet(1).get(2);
        Book book2 = new BookDAO().getListOfBookByNameAndIdBookSet("a", 2).get(0);
        Assert.assertEquals(book1.getSet().getName(), book2.getSet().getName());
    }

    /*Test chuc nang Xem chi tiet sach*/
    //Kiem thu ten, gia ban, ten danh muc cua sach co chi tiet sau:
    //  ten sach: Pippi tất dài ( Tái Bản)
    //  gia ban: 53000
    //  ten danh muc: Tình cảm
    //voi cac thong tin ten, gia ban, ten danh muc cua sach khi click chon xem
    //xem chi tiet cua sach tren
    // Ket qua mong muon: Pass
    @Test
    public void ViewBookTest1() {
        Book book = new BookDAO().getBookById(9);
        Assert.assertEquals("Pippi tất dài ( Tái Bản)", book.getTitle());
        Assert.assertEquals("26500.0", book.getSalePrice());
        Assert.assertEquals("Tình cảm", book.getCategory().getName());
    }

    //Kiem thu ten cua sach co chi ten sau: Pippi tất dài ( Tái Bản)
    //voi ten cua sach khi click chon xem chi tiet sach "Tôi Là Bêtô (Tái Bản 2015)"
    // Ket qua mong muon: Fail
    @Test
    public void ViewBookTest2() {
        Book book = new BookDAO().getBookById(4);
        Assert.assertEquals("Pippi tất dài ( Tái Bản)", book.getTitle());
    }
    
    /*Test chuc nang Cap nhat trang thai don hang*/
    //Kiem thu trang thai don hang thu 7 trong danh sach don hang
    //cua khach hang co thong tin sau: 0123123123 - txt.d12ptit@gmail.com
    //sau khi cap nhat voi trang thai "Đang giao hàng"
    //voi trang thai cua don hang tren khi dang nhap voi thong tin cua khach hang tren
    //Ket qua mong muon: Pass
    @Test
    public void UpdateStateTest1(){
        Order order1 = new OrderDAO().getAllOrder().get(6);
        CustomerMember cusMb = new CustomerMember();
        cusMb.setIdCustomer(1);
        Order order2 = new OrderDAO().getListOrderByMbId(cusMb).get(0);
        Assert.assertEquals("Đang giao hàng", order1.getState());
        Assert.assertEquals("Đang giao hàng", order2.getState());
        Assert.assertEquals(order1.getState(), order2.getState());
    }
    
    //Kiem thu trang thai don hang dau tien trong danh sach don hang
    //cua khach hang co thong tin sau: 0123456789 - 123@gmail.com
    //sau khi cap nhat voi trang thai "Đã nhận" voi trang thai "Đã huỷ"
    //Ket qua mong muon: Fail
    @Test
    public void UpdateStateTest2(){
        Order order = new OrderDAO().getAllOrder().get(0);
        Assert.assertEquals("Đã huỷ", order.getState());
    }

}
