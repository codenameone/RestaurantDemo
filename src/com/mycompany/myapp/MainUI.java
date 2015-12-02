package com.mycompany.myapp;

import com.codename1.components.SpanButton;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * This class includes the user interface for the restaurant, most of the theme elements are derived from the 
 * designer and can be replaced there. To change a lot of the constants such as the address, title etc. you can 
 * use the static variables defined at the top
 */
public class MainUI extends Form {
    private static final String RESTAURANT_NAME = "Ratatouille";
    private static final double RESTAURANT_LATITUDE = 40.7127;
    private static final double RESTAURANT_LONGITUDE = 74.0059;
    private static final Coord RESTAURANT_LOCATION = new Coord(RESTAURANT_LATITUDE, RESTAURANT_LONGITUDE);
    private static final String RESTAURANT_PHONE_NUMBER = "+1800777777";
    private static final String RESTAURANT_DISPLAY_PHONE_NUMBER = "+1-800-777-7777";
    private static final String RESTAURANT_EMAIL = "restaurant@gmail.com";
    private static final String RESTAURANT_DISPLAY_ADDRESS = "Ratatouille\n55 3rd street\nNY NY 66666";
    
    private static final boolean INCLUDE_RESERVATIONS = true;
    private static final String OPEN_TABLE_RESERVATION_ID = "168";
    
    private static final Dish[] DISHES = new Dish[] {
        new Dish("asian-salad.jpg", 
                "Asian Salad", 
                "$10", 
                "Root vegetables in asian style dressing", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("cheese-sandwitch.jpg", 
                "Cheese Sandwitch", 
                "$12", 
                "Cheese, vegetables and italian dressing", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("cupcakes.jpg", 
                "Chocolate Cupcakes", 
                "$8", 
                "Delicious silky creamy chocolate cupcakes", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("pizza.jpg", 
                "Pizza", 
                "$15", 
                "Fresh baked pizza with a variaty of toppings", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("strawberry-tart.jpg", 
                "Strawberry Tart", 
                "$11", 
                "Straberries, creme and flaky crust...", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("asian-salad.jpg", 
                "Asian Salad", 
                "$10", 
                "Root vegetables in asian style dressing", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
        new Dish("asian-salad.jpg", 
                "Asian Salad", 
                "$10", 
                "Root vegetables in asian style dressing", 
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris feugiat ipsum at condimentum malesuada. Aenean eu posuere lorem. Aliquam mollis, velit non mollis rutrum, mauris justo efficitur eros, non hendrerit nisi ex eu est. Aenean feugiat mauris eget quam laoreet vulputate. Fusce nec laoreet dolor. Sed accumsan orci quis tincidunt ullamcorper. Aliquam erat volutpat. Ut porta cursus finibus. Suspendisse tincidunt ipsum in nisl semper, non sagittis ipsum volutpat. Cras nec bibendum tellus. Fusce scelerisque nisl sit amet quam tristique aliquam. Pellentesque vel massa varius, lobortis turpis nec, commodo arcu. "),
    };
    
    private Resources theme;
    
    public MainUI(Resources theme) {
        super(RESTAURANT_NAME);
        this.theme = theme;
        Toolbar t = new Toolbar();
        setToolBar(t);
        t.setScrollOffUponContentPane(true);
        
        Label rat = new Label(theme.getImage("round_logo.png"));
        rat.setTextPosition(Label.BOTTOM);
        rat.setText(RESTAURANT_NAME);
        rat.setUIID("SideMenuLogo");
        t.addComponentToSideMenu(rat);
        setLayout(new BorderLayout());
        
        Container dishes = createDishesContainer();
        addComponent(BorderLayout.CENTER, dishes);
        revalidate();
        
        Style iconStyle = UIManager.getInstance().getComponentStyle("SideCommandIcon");
        
        t.addCommandToSideMenu(new Command("Menu", FontImage.create(" \ue93f ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showDishesContainer();
            }
        });
        if(INCLUDE_RESERVATIONS) {
            t.addCommandToSideMenu(new Command("Reservation", FontImage.create(" \ue838 ", iconStyle)) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Display.getInstance().execute("reserve://opentable.com/" + OPEN_TABLE_RESERVATION_ID +  "?partySize=2");
                }
            });
        }
        t.addCommandToSideMenu(new Command("Find Us", FontImage.create(" \ue8d5 ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showMap();
            }
        });
        t.addCommandToSideMenu(new Command("Contact Us", FontImage.create(" \ue86b ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showContactUs();
            }
        });
        t.addCommandToSideMenu(new Command("Navigate", FontImage.create(" \ue85b ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openNativeNavigationApp(RESTAURANT_LATITUDE, RESTAURANT_LONGITUDE);
            }
        });
    }

    private void showContactUs() {
        getContentPane().replace(getContentPane().getComponentAt(0), createContactUs(), CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private Container createContactUs() {
        BorderLayout abs = new BorderLayout();
        abs.setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE);
        Container contactUsParent = new Container(abs);
        
        Container contactUs = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        contactUsParent.addComponent(BorderLayout.CENTER, contactUs);
        
        contactUs.setScrollableY(true);
        
        Button phone = new Button(RESTAURANT_DISPLAY_PHONE_NUMBER);
        phone.addActionListener((e) -> {
            Display.getInstance().dial(RESTAURANT_PHONE_NUMBER);
        });
        
        phone.setUIID("Label");
        contactUs.addComponent(phone);
        contactUs.setUIID("ContactUsLayer");
        contactUsParent.setUIID("ContactUs");

        Button email = new Button(RESTAURANT_EMAIL);
        email.addActionListener((e) -> {
            Message m = new Message("Type your message here:\n");
            Display.getInstance().sendMessage(new String[] {RESTAURANT_EMAIL}, "Contact from app", m);
        });
        
        email.setUIID("Label");
        contactUs.addComponent(email);
        
        SpanButton address = new SpanButton(RESTAURANT_DISPLAY_ADDRESS);
        address.setUIID("Container");
        address.setTextUIID("Label");
        address.addActionListener((e) -> {
            Display.getInstance().openNativeNavigationApp(RESTAURANT_LATITUDE, RESTAURANT_LONGITUDE);
        });
        
        contactUs.addComponent(address);
        
        return contactUsParent;
    }
    
    private void showMap() {
        MapContainer mc = new MapContainer();
        mc.addMarker((EncodedImage)theme.getImage("round_logo.png"), RESTAURANT_LOCATION, RESTAURANT_NAME, RESTAURANT_NAME, null);
        mc.zoom(RESTAURANT_LOCATION, mc.getMaxZoom() - 2);
        getContentPane().replace(getContentPane().getComponentAt(0), mc, CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private void showDishesContainer() {
        Container dishes = createDishesContainer();
        getContentPane().replace(getContentPane().getComponentAt(0), dishes, CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private Container createDishesContainer() {
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.setScrollableY(true);
        
        // allows elements to slide into view
        for(Dish d : DISHES) {
            Component dish = createDishComponent(d);
            cnt.addComponent(dish);            
        }        
        return cnt;
    }
    
    private Container createDishComponent(Dish d) {
        Image img = theme.getImage(d.getImageName());
        Container mb = new Container(new BorderLayout());
        mb.getUnselectedStyle().setBgImage(img);
        mb.getSelectedStyle().setBgImage(img);
        mb.getPressedStyle().setBgImage(img);
        mb.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        mb.getSelectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        mb.getPressedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Container box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Button title = new Button(d.getDishName());
        title.setUIID("DishTitle");
        Label highlights = new Label(d.getHighlights());
        TextArea details = new TextArea(d.getFullDescription());
        details.setUIID("DishBody");
        highlights.setUIID("DishBody");
        Label price = new Label(d.getPrice());
        price.setUIID("DishPrice");
        box.addComponent(title);
        box.addComponent(highlights);
        
        Container boxAndPrice = new Container(new BorderLayout());
        boxAndPrice.addComponent(BorderLayout.CENTER, box);
        boxAndPrice.addComponent(BorderLayout.EAST, price);
        mb.addComponent(BorderLayout.SOUTH, boxAndPrice);
        
        mb.setLeadComponent(title);
        
        title.addActionListener((e) -> {
            if(highlights.getParent() != null) {
                box.removeComponent(highlights);
                box.addComponent(details);
            } else {
                box.removeComponent(details);
                box.addComponent(highlights);
            }
            mb.getParent().animateLayout(300);
        });
        return mb;
    }
    
    
}
