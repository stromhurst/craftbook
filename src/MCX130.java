// $Id$
/*
 * CraftBook
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */



import com.sk89q.craftbook.ic.ChipState;


/**
 * Mob Zapper.
 *
 * 
 */
public class MCX130 extends MCX119 {
    

    /**
     * Get the title of the IC.
     *
     * @return
     */
	@Override
    public String getTitle() {
        return "MOB ZAPPER";
    }
    
	@Override
    public boolean requiresPermission() {
        return true;
    }
    
	@Override
	public ResultHandlerWithOutput rhFactory(ChipState chip) {
		return new RHDestroyFoundEntities(chip);
	}
	

}
