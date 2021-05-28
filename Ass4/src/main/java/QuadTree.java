import java.util.*;


public class QuadTree {
    public QTreeNode root;
    private String imageRoot;

    public QuadTree(String imageRoot) {
        // Instantiate the root element of the tree with depth 0
        // Use the ROOT_ULLAT, ROOT_ULLON, ROOT_LRLAT, ROOT_LRLON static variables of MapServer class
        // Call the build method with depth 1
        // Save the imageRoot value to the instance variable
        /* Code here */
        this.root = new QTreeNode("root", 0, 0, 0, 0, 0);
        this.imageRoot = imageRoot;
        build(root,0);

    }

    public void build(QTreeNode subTreeRoot, int depth) {
        // Recursive method to build the tree as instructed
        /* Code here */
        if(depth == 8){
            return;
        }

        double newULLON, newULLAT, newLRLON, newLRLAT;
        QTreeNode n = subTreeRoot;
        /* 1: Upper left tile: same ULLON & ULLAT, diff LRLON & LRLAT */
        newULLON = n.getUpperLeftLongtitude();
        newULLAT = n.getUpperLeftLatitude();
        newLRLON = ((n.getLowerRightLongtitude() - n.getUpperLeftLongtitude()) / 2) + n.getUpperLeftLongtitude();
        newLRLAT = ((n.getUpperLeftLatitude() - n.getLowerRightLatitude()) / 2) + n.getLowerRightLatitude();  // order switched bc ULLAT > LRLAT
        if(n.getName().equals("root")){n.NW = new QTreeNode("1", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1); }
        else{
            n.NW = new QTreeNode(n.getName() + "1", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1);
        }
        System.out.println(n.getName());
        build(n.NW, depth + 1);


        /* 2: Upper right tile: same ULLAT & LRLON, diff ULLON & LRLAT */
        newULLON = ((n.getLowerRightLongtitude() - n.getUpperLeftLongtitude()) / 2) + n.getUpperLeftLongtitude();
        newULLAT = n.getUpperLeftLatitude();
        newLRLON = n.getLowerRightLongtitude();
        newLRLAT = ((n.getUpperLeftLatitude() - n.getLowerRightLatitude()) / 2) + n.getLowerRightLatitude();
        if(n.getName().equals("root")){n.NE = new QTreeNode("2", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1); }
        else{
            n.NE = new QTreeNode(n.getName() + "2", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1);
        }
        build(n.NE, depth + 1);

        /* 3: Lower left tile: same ULLON & LRLAT, diff ULLAT & LRLON */
        newULLON = n.getUpperLeftLongtitude();
        newULLAT = ((n.getUpperLeftLatitude() - n.getLowerRightLatitude()) / 2) + n.getLowerRightLatitude();
        newLRLON = ((n.getLowerRightLongtitude() - n.getUpperLeftLongtitude()) / 2) + n.getUpperLeftLongtitude();
        newLRLAT = n.getLowerRightLatitude();
        if(n.getName().equals("root")){n.SW = new QTreeNode("3", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1); }
        else{
            n.SW = new QTreeNode(n.getName() + "3", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1);
        }
        build(n.SW, depth + 1);

        /* 4: Lower right tile: same LRLON & LRLAT, diff ULLON & ULLAT */
        newULLON = ((n.getLowerRightLongtitude() - n.getUpperLeftLongtitude()) / 2) + n.getUpperLeftLongtitude();
        newULLAT = ((n.getUpperLeftLatitude() - n.getLowerRightLatitude()) / 2) + n.getLowerRightLatitude();
        newLRLON = n.getLowerRightLongtitude();
        newLRLAT = n.getLowerRightLatitude();
        if(n.getName().equals("root")){n.SE = new QTreeNode("4", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1); }
        else{
            n.SE = new QTreeNode(n.getName() + "4", newULLAT,newULLON, newLRLAT, newLRLON,depth + 1);
        }
        build(n.SE, depth + 1);
    }

    public Map<String, Object> search(Map<String, Double> params) {
        /*
         * Parameters are:
         * "ullat": Upper left latitude of the query box
         * "ullon": Upper left longitude of the query box
         * "lrlat": Lower right latitude of the query box
         * "lrlon": Lower right longitude of the query box
         * */

        // Instantiate a QTreeNode to represent the query box defined by the parameters
        // Calculate the lonDpp value of the query box
        // Call the search() method with the query box and the lonDpp value
        // Call and return the result of the getMap() method to return the acquired nodes in an appropriate way
        /* Code here */


        return new HashMap<>();
    }

    private Map<String, Object> getMap(ArrayList<QTreeNode> list) {
        Map<String, Object> map = new HashMap<>();

        // Check if the root intersects with the given query box
        if (true/* Replace *//* Code here */) {
            map.put("query_success", false);
            return map;
        }

        // Use the get2D() method to get organized images in a 2D array
        map.put("render_grid", null/* Replace *//* Code here */);

        // Upper left latitude of the retrieved grid (Imagine the
        // 2D string array you have constructed as a big picture)
        map.put("raster_ul_lat", null/* Replace *//* Code here */);

        // Upper left longitude of the retrieved grid (Imagine the
        // 2D string array you have constructed as a big picture)
        map.put("raster_ul_lon", null/* Replace *//* Code here */);

        // Upper lower right latitude of the retrieved grid (Imagine the
        // 2D string array you have constructed as a big picture)
        map.put("raster_lr_lat", null/* Replace *//* Code here */);

        // Upper lower right longitude of the retrieved grid (Imagine the
        // 2D string array you have constructed as a big picture)
        map.put("raster_lr_lon", null/* Replace *//* Code here */);

        // Depth of the grid (can be thought as the depth of a single image)
        map.put("depth", null/* Replace *//* Code here */);

        map.put("query_success", true);
        return map;
    }

    private String[][] get2D(ArrayList<QTreeNode> list) {
        String[][] images = new String[0][0];
        // After you retrieve the list of images using the recursive search mechanism described above, you
        // should order them as a grid. This grid is nothing more than a 2D array of file names. To order
        // the images, you should determine correct row and column for each image (node) in the retrieved
        // list. As a hint, you should consider the latitude values of images to place them in the row, and
        // the file names of the images to place them in a column.
        /* Code here */
        return images;
    }

    public void search(QTreeNode queryBox, QTreeNode tile, double lonDpp, ArrayList<QTreeNode> list) {
        // The first part includes a recursive search in the tree. This process should consider both the
        // lonDPP property (discussed above) and if the images in the tree intersect with the query box.
        // (To check the intersection of two tiles, you should use the checkIntersection() method)
        // To achieve this, you should retrieve the first depth (zoom level) of the images which intersect
        // with the query box and have a lower lonDPP than the query box.
        // This method should fill the list given by the "ArrayList<QTreeNode> list" parameter
        /* Code here */
    }

    public boolean checkIntersection(QTreeNode tile, QTreeNode queryBox) {
        // Return true if two tiles are intersecting with each other
        /* Code here */
        return false;
    }
}