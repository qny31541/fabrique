package org.jodah.fabrique.intercept;

import java.lang.reflect.AccessibleObject;

/**
 * This interface represents a generic runtime joinpoint (in the AOP terminology).
 * 
 * <p>
 * A runtime joinpoint is an event that occurs on a static joinpoint (i.e. a location in a the
 * program). For instance, an invocation is the runtime joinpoint on a method (static joinpoint).
 * The static part of a given joinpoint can be generically retrieved using the {@link
 * getStaticPart()} method.
 * 
 * <p>
 * In the context of an interception framework, a runtime joinpoint is then the reification of an
 * access to an accessible object (a method, a constructor, a field), i.e. the static part of the
 * joinpoint. It is passed to the interceptors that are installed on the static joinpoint.
 * 
 * @author AOP Alliance
 */
public interface Joinpoint {
  /**
   * Returns the static part of this joinpoint. The static part is an accessible object on which a
   * chain of interceptors are installed.
   * 
   * @return AccessibleObject
   */
  AccessibleObject getStaticPart();

  /**
   * Returns the object that holds the current joinpoint's static part. For instance, the target
   * object for an invocation.
   * 
   * @return The object (can be null if the accessible object is static).
   */
  Object getThis();

  /**
   * Proceeds to the next interceptor in the chain. The implementation and the semantics of this
   * method depends on the actual joinpoint type (see the children interfaces).
   * 
   * @return See the children interfaces' proceed definition.
   * @throws Throwable If the joinpoint throws an exception.
   */
  Object proceed() throws Throwable;
}
