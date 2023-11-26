package io.github.jeromewolff.test.repository;

import io.github.jeromewolff.test.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code MessageRepository} interface provides CRUD operations for the {@link Message} entity using Spring Data JPA.
 * It extends the {@link JpaRepository} interface, which provides generic CRUD operations for entities.
 *
 * <p>{@link JpaRepository} provides methods like save, findOne, findAll, count, and delete, among others,
 * making it easy to interact with the underlying data store without writing boilerplate code.
 * In this case, the entity type is {@link Message}, and the primary key type is {@link Long}.
 *
 * <p>This interface is annotated with {@link Repository}, indicating that it should be discovered by Spring
 * and used as a repository for managing instances of the {@link Message} entity.
 *
 * @author Jerome Wolff
 * @see JpaRepository
 * @see Message
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> { }
