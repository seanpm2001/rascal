/** 
 * Copyright (c) 2016, paulklint, Centrum Wiskunde & Informatica (CWI) 
 * All rights reserved. 
 *  
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: 
 *  
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
 *  
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution. 
 *  
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */ 
package org.rascalmpl.library.experiments.Compiler.RVM.Interpreter.ideservices;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

import org.rascalmpl.debug.IRascalMonitor;

/**
 * IDEServices provides external services that can be called by the
 * Rascal compiler and compiled REPL.
 */
public interface IDEServices extends IRascalMonitor {

  /**
   * Open a browser for the give uri.
   * @param uri
   */
  void browse(URI uri);

  /**
   * Open an editor for file at given path.
   * @param path
   */
  void edit(Path path);
  
  
  /**
   * Start watching changes in the given directory and all its subdirectories.
   * @param dir
   * @throws IOException
   */
  void watch(Path dir) throws IOException;
  
  /**
   * Stop watching changes in the given directory and all its subdirectories.
   * @param dir
   * @throws IOException 
   */
  void unwatch(Path dir) throws IOException;
  
  /**
   * Stop watching any watched directories.
   * @throws IOException
   */
  void unwatchAll() throws IOException;
  
  /**
   * Get file changes.
   * @return a list of changed files in the watched directories
   */
  Iterable<Path> fileChanges();

  /**
   * Did any file change?
   * @return true if any file has changed in the watched directories
   */
  boolean anyFileChanges();

}