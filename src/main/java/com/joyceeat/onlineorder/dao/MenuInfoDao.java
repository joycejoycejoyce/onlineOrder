package com.joyceeat.onlineorder.dao;

import com.joyceeat.onlineorder.entity.MenuItem;
import com.joyceeat.onlineorder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.createCriteria(Restaurant.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        try (Session session = sessionFactory.openSession()) {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
