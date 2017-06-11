/*
 * Copyright (C) 2017 naluem
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dependencyinjection.complex;

import com.dependencyinjection.Implementations.ImplementationA1;
import com.dependencyinjection.Interfaces.InterfaceB;
import com.dependencyinjection.Interfaces.InterfaceC;
import com.dependencyinjection.common.DependencyException;

/**
 *
 * @author naluem
 */
public class FactoryA1 implements Factory<ImplementationA1> {

    @Override
    public ImplementationA1 create(Object... parameters) throws DependencyException {
        InterfaceB b;
        InterfaceC c;
        try {
            b = (InterfaceB) parameters[0];
            c = (InterfaceC) parameters[1];
        } catch (ClassCastException | ArrayIndexOutOfBoundsException ex) {
            throw new DependencyException(ex);
        }
        return new ImplementationA1(b, c);
    }
}
