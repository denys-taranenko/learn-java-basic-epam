package com.epam.java.basics.module_17_lists_and_queues.task_3_new_post_office_storage;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * This interface describes the business logic of New Post storage service.
 */
public interface NewPostOfficeStorage {

    /**
     * Appends the specified parcel to the end of this storage.
     *
     * @param box a parcel to add.
     * @return {@code true} if this storage is changed.
     * @throws NullPointerException if the parameter is {@code null}.
     */
    boolean acceptBox(Box box);

    /**
     * Appends to this storage all parcels that are contained
     * in the specified collection.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection that contains parcels to add.
     * @return {@code true} if this storage is changed.
     * @throws NullPointerException if the parameter is {@code null} or contains {@code null} values.
     */
    boolean acceptAllBoxes(Collection<Box> boxes);

    /**
     * Removes from this storage all of its parcels that
     * are contained in the specified collection.
     *
     * @param boxes a collection that contains parcels to
     *               remove from this storage
     * @return new instance of {@code NewPostOfficeStorage} that contains all
     * removed parcels from this storage.
     * @throws NullPointerException if the parameter is {@code null}
     * or contains {@code null} values.
     */
    boolean carryOutBoxes(Collection<Box> boxes);

    /**
     * Removes from this storage all of its parcels that
     * are satisfied the specified predicate
     *
     * @param predicate represents a predicate (boolean-valued function)
     *                  of one argument.
     * @return a List that contains all removed parcels from this storage.
     * @throws NullPointerException if the parameter is {@code null}.
     */
    List<Box> carryOutBoxes(Predicate<Box> predicate);

    /**
     * Selects all parcels whose weight is less than the parameter value.
     *
     * @param weight the weight of a box
     * @return a List that contains all founded parcels.
     * @throws IllegalArgumentException if the parameter is less than or equal to zero.
     * @see NewPostOfficeStorage#searchBoxes(Predicate)
     */
    List<Box> getAllWeightLessThan(double weight);

    /**
     * Selects all parcels whose cost is greater than the parameter value.
     *
     * @param cost the cost of a box
     * @return  a List that contains all founded parcels.
     * @throws NullPointerException if the parameter is {@code null}.
     * @throws IllegalArgumentException if the parameter is less than zero.
     * @see NewPostOfficeStorage#searchBoxes(Predicate)
     */
    List<Box> getAllCostGreaterThan(BigDecimal cost);

    /**
     * Selects all parcels whose volume is greater than or equal to the parameter value.
     *
     * @param volume the volume of a box
     * @return  a List that contains all founded parcels.
     * @throws IllegalArgumentException if the parameter is less than zero.
     * @see NewPostOfficeStorage#searchBoxes(Predicate)
     */
    List<Box> getAllVolumeGreaterOrEqual(double volume);

    /**
     * Searches parcels using a predicate. This method does not change the original storage.
     *
     * @param predicate represents a predicate (boolean-valued function) of one argument.
     * @return a List of selected boxes.
     * @throws NullPointerException if the parameter is {@code null}.
     */
    List<Box> searchBoxes(Predicate<Box> predicate);

    /**
     * Updates the {@code office} field in each box of this storage.
     *
     * @param predicate represents a predicate (boolean-valued function) of one argument.
     * @param newOfficeNumber the office number to set.
     * @throws NullPointerException if {@code boxes} the predicate is null.
     * @throws IllegalArgumentException if {@code newOfficeNumber} is negative or equals to zero.
     */
    void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber);
}
