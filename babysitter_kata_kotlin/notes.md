# Austin's Notes

Thank you for making this a public repo! Much easier for me to review, and gives that sweet sweet github cred.

I put my general notes here and then left comments / made changes where relevant in the code.

Mockito seems like a smell. Why is it needed? (Looks like maybe it was just a left over)

Pay attention to squigglies, they usually help you write better code. (I only noticed one squiggle!)

Tests pass in ide but not in the terminal, looks like you'd need to add a test platform. (See build.gradle for comments)

I was expecting the traditional kata: one commit/one test but then realized this was more of a conversion thing.

looks like out/ wasn't ignored and so you've got some build artifacts being tracked by git. Those can be annoying and add noise, so be careful to update your git ignore on initial commits / when you see added stuff like that. You can remove them from tracking afterwords, but it's annoying. Let me know if you want to try that together some time.

Looks good to me! I didn't really notice any 'this was written as java first, wasn't it' sort of stuff. Nice!