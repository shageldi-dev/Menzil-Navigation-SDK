package com.mapbox.services.android.navigation.v5.models;

import com.google.gson.GsonBuilder;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;

import java.io.Serializable;

/**
 * Provides a base class for Directions model classes.
 *
 * @since 3.4.0
 */
public class DirectionsJsonObject implements Serializable {

  /**
   * This takes the currently defined values found inside this instance and converts it to a json
   * string.
   *
   * @return a JSON string which represents this DirectionsJsonObject
   * @since 3.4.0
   */
  public String toJson() {
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    gson.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
    gson.registerTypeAdapterFactory(WalkingOptionsAdapterFactory.create());
    return gson.create().toJson(this);
  }
}
