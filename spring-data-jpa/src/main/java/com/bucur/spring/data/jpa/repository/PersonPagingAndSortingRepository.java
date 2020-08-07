package com.bucur.spring.data.jpa.repository;

import com.bucur.spring.data.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The findAll(Pageable pageable) method by default returns a Page<T> object.
 * <p>
 * However, we can choose to return either a Page<T>, a Slice<T> or a List<T> from any of our custom methods
 * returning a paginated data.
 * <p>
 * A Page<T> instance, in addition to having the list of Products, also knows about the total number of available
 * pages. It triggers an additional count query to achieve it. To avoid such an overhead cost, we can instead
 * return a Slice<T> or a List<T>.
 * <p>
 * A Slice only knows about whether the next slice is available or not.
 */
@Repository
public interface PersonPagingAndSortingRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByAge(int age, Pageable pageable);
}
