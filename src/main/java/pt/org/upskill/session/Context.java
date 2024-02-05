package pt.org.upskill.session;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.auth.User;
import pt.org.upskill.db.*;
import pt.org.upskill.ui.menu.Drawable;
import pt.org.upskill.ui.menu.Menu;

public class Context {

    public static Context getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Context INSTANCE = new Context();
    }

    //Main Menu
    private Menu mainMenu;

    public void setMainMenu(Menu menu) {
        this.mainMenu = menu;
    }

    ;

    public Menu mainMenu() {
        return mainMenu;
    }

    //Menu Drawer
    private Drawable drawer;

    public void setDrawer(Drawable drawer) {
        this.drawer = drawer;
    }

    ;

    public Drawable drawer() {
        return drawer;
    }

    //Session
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public Session session() {
        return session;
    }

    public User userLoggedIn() {
        if (session() != null) {
            return session.user();
        }
        return null;
    }

    private static ConnectionSnsUser csu = new ConnectionSnsUser();

    public static ConnectionSnsUser getConnectionSnsUser() {
        return csu;
    }

    //Connection Employee
    private static ConnectionEmployee ce = new ConnectionEmployee();

    public static ConnectionEmployee getConnectionEmployee() {
        return ce;
    }

    private static ConnectionVaccine cv = new ConnectionVaccine();

    public static ConnectionVaccine getConnectionVaccine() {
        return cv;
    }

    private static ConnectionFactory cf = new ConnectionFactory();

    public static ConnectionFactory getConnectionFactory() {
        return cf;
    }

    private static ConnectionAppointment ca= new ConnectionAppointment();
    public static ConnectionAppointment getConnectionAppointment(){return ca;}


}