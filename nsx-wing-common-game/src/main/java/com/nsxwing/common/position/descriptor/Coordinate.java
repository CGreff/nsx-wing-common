package com.nsxwing.common.position.descriptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple class used to mark x and y coordinates of a point.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    public double x;
    public double y;
}
