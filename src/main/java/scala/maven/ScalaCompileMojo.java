/*
 * Copyright 2007 scala-tools.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
 package scala.maven;

import java.io.File;
import java.util.List;

/**
 * Compiles a directory of Scala source. Corresponds roughly to the compile goal
 * of the maven-compiler-plugin
 *
 * @phase compile
 * @goal compile
 * @requiresDependencyResolution compile
 */
public class ScalaCompileMojo extends ScalaCompilerSupport {

    /**
     * @parameter expression="${project.build.outputDirectory}"
     */
    protected File outputDir;

    /**
     * @parameter expression="${project.build.sourceDirectory}/../scala"
     */
    protected File sourceDir;

    @SuppressWarnings("unchecked")
    @Override
    protected List<String> getClasspathElements() throws Exception {
        return project.getCompileClasspathElements();
    }

    @Override
    protected File getOutputDir() throws Exception {
        return outputDir.getAbsoluteFile();
    }

    @Override
    protected File getSourceDir() throws Exception {
        return sourceDir.getAbsoluteFile();
    }

    @Override
    protected void doExecute() throws Exception {
    	String path = getSourceDir().getAbsolutePath();
    	if (project.getCompileSourceRoots().contains(path)) {
    		project.addCompileSourceRoot(path);
    	}
    	super.doExecute();
    }
}