package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DeleteAllCommand extends Command {
    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes all persons whose names contain any of "
            + "the specified keywords (case-sensitive). Removes the last listing.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Command finder;

    public DeleteAllCommand(Set<String> keywords) {
        finder = new FindCommand(keywords);
    }


    @Override
    public CommandResult execute() {
        CommandResult found = finder.execute();
        final Optional<List<? extends ReadOnlyPerson>> personList = found.getRelevantPersons();
        if (personList.isPresent()) {
            List<? extends ReadOnlyPerson> list = personList.get();
            DeleteCommand deleter = new DeleteCommand(0);
            deleter.setData(addressBook, list);
            for (int i = 0; i < list.size(); i++) {
                deleter.setTargetIndex(i);
                deleter.execute();
            }
        }
        return found;
    }


}
