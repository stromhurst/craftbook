/*    
Craftbook 
Copyright (C) 2010 Lymia <lymiahugs@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lymia.util.Tuple2;

/**Canary provides methods for everything this class can do. Please use those instead.
 * 
 * Finds all currently loaded chunks in a world. 
 * 
 * @author Lymia
 * @deprecated
 */
@Deprecated
public class ChunkFinder {
    private ChunkFinder() {}
    
    /**
     * @deprecated
     * @param world
     * @return
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    public static Tuple2<Integer,Integer>[] getLoadedChunks(OWorld world) {
        List<Tuple2<Integer,Integer>> chunkList = new ArrayList<Tuple2<Integer,Integer>>();
        List<OChunk> list = (List<OChunk>)get(get(world,"w"),"g");
        for(OChunk chunk:list.toArray(new OChunk[0])) if(chunk!=null) chunkList.add(getChunkCoords(chunk));
        return chunkList.toArray((Tuple2<Integer, Integer>[]) new Tuple2<?,?>[0]);
    }
    
    private static Tuple2<Integer,Integer> getChunkCoords(OChunk chunk) {
        return new Tuple2<Integer,Integer>(chunk.g,chunk.h);
    }
    
    private static Object get(Object o, String field) {
        try {
            return get(o,o.getClass(),field);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("NoSuchFieldException thrown. CraftBook likely needs updating",e);
        }
    }
    private static Object get(Object o, Class<?> c, String field) throws NoSuchFieldException {
        if(c==Object.class) throw new NoSuchFieldException(field);
        try {
            Field f = c.getDeclaredField(field);
            f.setAccessible(true);
            return f.get(o);
        } catch (NoSuchFieldException e) {
            return get(o,c.getSuperclass(),field);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("IllegalArgumentException thrown. CraftBook likely needs updating",e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException thrown. CraftBook likely needs updating",e);
        }
    }
}
