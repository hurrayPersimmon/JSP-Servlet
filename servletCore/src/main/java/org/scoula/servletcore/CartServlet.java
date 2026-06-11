package org.scoula.servletcore;

import java.io.IOException;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.scoula.servletcore.dto.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private Map<Integer, Product> productDB;

    @Override
    public void init() {
        productDB = new HashMap<>();
        productDB.put(1, new Product(1, "사과", 1000, "img/apple.jpg"));
        productDB.put(2, new Product(2, "바나나", 1200, "img/banana.jpg"));
        productDB.put(3, new Product(3, "딸기", 1500, "img/strawberry.jpg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        if (action.equals("add")) {
            Product product = productDB.get(id);
            cart.add(product);
        } else if (action.equals("remove")) {
            cart.removeIf(p -> p.getId() == id);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart/cart.jsp");
    }
}

