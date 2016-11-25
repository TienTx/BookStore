/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import controller.LoadDefaultData;
import dao.order.CardPointDAO;
import dao.order.CartDAO;
import entity.order.CardPoint;
import entity.order.Cart;
import entity.person.customer.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zOzDarKzOz
 */
@Controller
public class CardPointCtr {

    @RequestMapping(value = "cardpoint.html")
    public ModelAndView cardPoint(ModelAndView model,
            HttpServletRequest request, HttpServletResponse response) {
        model = new ModelAndView("/front/cardpoint");
        LoadDefaultData.getAndSetCookieAndScopeOfCategoryAndBookSet(request, response, model);
        return model;
    }

    @RequestMapping(value = "cardpoint/checkcardpoint")
    public @ResponseBody
    String checkCardPoint(@RequestParam("code") String code) {
        String res = "fail";
        if (code != null && code.trim().matches("([0-9a-zA-Z]){6,6}")) {
            CardPoint cardPoint = new CardPointDAO().getCustomerCardPointByCode(code);
            if (cardPoint != null) {
                if (cardPoint.getCardCode().equals(code.toUpperCase())) {
                    int p = cardPoint.getPoints();
                    res = p + "#" + cardPoint.getCustomer().getEmail()
                            + "#" + cardPoint.getCustomer().getPhoneNum();
                }
            }
        }
        return res;
    }
}
