package CUOM;

/**
 * Created by user on 17.10.2019.
 */
import CUOM.Resources_Sources.FoodSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class World {
    int Camera_x;
    int Camera_y;
    String Name;
    ArrayList<Chunk> Chunks;
    public Chunk find_chunk(int x, int y)
    {
        return Chunks.get(0);
    }
    public void create_world()
    {

        File WordlFile = new File( "src/CUOM/Worlds/" + Name + ".txt");
        FileWriter World_Writer;
    }
}
