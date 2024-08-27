async function fetchGitHubRepoStats(repo, elementId) {
    const url = `https://api.github.com/repos/${repo}`;

    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Error fetching the repository data: ${response.statusText}`);
        }
        const data = await response.json();

        // Populate stats
        const statsContainer = document.getElementById(elementId);
        if (statsContainer) {
            statsContainer.innerHTML = `
                        <div class="stat">⭐ Stars: ${data.stargazers_count}</div>
                        <div class="stat">🍴 Forks: ${data.forks_count}</div>
                    `;
        }

    } catch (error) {
        console.error(error);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const statsElements = document.querySelectorAll('.stats');
    statsElements.forEach(statsElement => {
        const repoId = statsElement.id;
        fetchGitHubRepoStats(repoId, repoId);
    });
});