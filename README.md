# SE_LAB
Question1) The .git folder contains all the information that is necessary for your project in version control and all the information about commits, remote repository address, etc. All of them are present in this folder. It also contains a log that stores your commit history so that you can roll back to history.<br/>
.git is initialized by git init<br/>
every time you use 'git *' command there, You can move the .git directory somewhere else using:<br/>
git --git-dir=/myproject_path/myproject.git log —oneline<br/>
Or:<br/>
export GIT_DIR=/myproject_path/myproject.git

Question2) Commits should be “atomic" means: a single commit should be dedicated to a single (sub)task.
atomic in atomic pull-request means: in addition to seeing more information about your existing pull requests, you can also open a new pull request directly from Atom.

Question3) git fetch is about retrieving data from a remote repository.
git pull (I know you didn't ask about pull but bear with me) is a shorthand that retrieves data from the remote like fetch, then merges into your current branch the corresponding line of work from the remote (if there is one; the "tracking information" determines this.)
git merge is about combining work from multiple lines of work (usually local branches).

Question4) The Reset, or we can say rollback feature helps to undo modifications in the Git repository and will return the current environment to the previous commit.
Git Revert operation is quite similar to the Git Reset command; the only difference is that you need a new commit to go back to the specific commit while performing this operation.
And the last one is the Git Rebase which is used to merge or combine the sequence of commits on the repository. It is different from the merge command as the “merge” command is used to combine commits history and maintain the record as it happened, whereas “rebase” commands rewrite or reapply the history of commits on the top of another branch.
The Git Restore function is used to restore content from commits in the working directory. Whenever you perform a restore command, it will change the commit history and specify the paths.

Question5) A staging step in git allows you to continue making changes to the working directory, and when you decide you wanna interact with version control, it allows you to record changes in small commits.
Stash means to store (changes) safely in a hidden place (the stash stack). Stashing the current working directory's staged or unstaged changes or untracked files and then storing them in the stash stack reverts the current working directory to the last commit.

Question6) A snapshot is the state of something (e.g. a folder) at a specific point in time. In this case, snapshot means the current content of the test branch, this doesn't have to be the head revision.
