
package com.trecyclerview.util;


import androidx.annotation.NonNull;

/**
 * @author tqzhang
 */
public final class Preconditions {

  public static @NonNull
  <T> T checkNotNull(final T reference) {
    if (reference == null) {
      throw new NullPointerException();
    }
    return reference;
  }


  private Preconditions() {}
}
